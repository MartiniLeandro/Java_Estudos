package dev.matheuslf.desafio.inscritos.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@Schema(description = "Classe dos users")
public class User {

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
}
