package com.treinoSecurity.Models;

import com.treinoSecurity.Models.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
    
}
