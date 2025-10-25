package dev.matheuslf.desafio.inscritos.entities;

import dev.matheuslf.desafio.inscritos.entities.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
@Schema(description = "Classe dos users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id do User",example = "1L",requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be null")
    @Schema(description = "nome do User",example = "user",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "Email cannot be null")
    @Schema(description = "email do User",example = "user@email.com",requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "Password cannot be null")
    @Schema(description = "password do User",example = "user123",requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NotNull
    @Schema(description = "Role do User",example = "USER",requiredMode = Schema.RequiredMode.REQUIRED)
    private Roles role;

    public User(String name, String email, String password, Roles roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Roles.ADMIN) return List.of(new SimpleGrantedAuthority("USER"),new SimpleGrantedAuthority("ADMIN"));
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

}
