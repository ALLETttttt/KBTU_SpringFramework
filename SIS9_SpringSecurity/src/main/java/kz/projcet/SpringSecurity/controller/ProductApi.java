package kz.projcet.SpringSecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import kz.projcet.SpringSecurity.entity.Product;
import kz.projcet.SpringSecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApi {

    @Autowired private ProductRepository repo;

    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
        Product savedProduct = repo.save(product);
        URI productURI = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }

    @GetMapping
    @RolesAllowed({"ROLE_CUSTOMER", "ROLE_EDITOR"})
    public List<Product> list() {
        return repo.findAll();
    }
}
