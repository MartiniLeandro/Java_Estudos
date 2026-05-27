package com.onsign.challenge.demo.models.DTOS;

import java.util.Set;

public record UserSuggestedResponseDTO(Long id, String name, Set<String> suggestedFriends, Set<String> suggestedInterests) {
}
