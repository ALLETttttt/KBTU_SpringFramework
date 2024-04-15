package kz.projcet.SpringSecurity.request;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

@Data
public class AuthRequest {
    @NotNull
    @Email
    @Length(min = 5, max = 50)
    private String email;

    @NotNull
    @Length(min = 5, max = 10)
    private String password;

    // getters and setters are not shown...
}
