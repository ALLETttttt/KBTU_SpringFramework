package kz.projcet.SpringSecurity.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import kz.projcet.SpringSecurity.entity.Role;
import kz.projcet.SpringSecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtUtil;


    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            return false;
        }

        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    private void setAuthenticationContext(String token, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(token);

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails((jakarta.servlet.http.HttpServletRequest) request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String token) {
        User userDetails = new User();
        Claims claims = jwtUtil.parseClaims(token);
        String subject = (String) claims.get(Claims.SUBJECT);
        String roles = (String) claims.get("roles");

        roles = roles.replace("[", "").replace("]", "");
        String[] roleNames = roles.split(",");

        for (String aRoleName : roleNames) {
            userDetails.addRole(new Role(aRoleName));
        }

        String[] jwtSubject = subject.split(",");

        userDetails.setId(Integer.parseInt(jwtSubject[0]));
        userDetails.setEmail(jwtSubject[1]);

        return userDetails;
    }

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!hasAuthorizationBearer((HttpServletRequest) request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = getAccessToken((HttpServletRequest) request);

        if (!jwtUtil.validateAccessToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        setAuthenticationContext(token, (HttpServletRequest) request);
        filterChain.doFilter(request, response);
    }
}