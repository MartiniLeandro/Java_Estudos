package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.User;

public record UserResponseDTO(Long id, String name, String email) {
    public UserResponseDTO(User user){
        this(
                user.getId(), user.getName(), user.getEmail()
        );
    }
}
