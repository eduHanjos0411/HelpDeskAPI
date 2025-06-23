package com.dudu.HelpDeskAPI.dto;

import com.dudu.HelpDeskAPI.model.User;
import lombok.Builder;

@Builder
public record UserResponse(
        String nome,
        String email
) {

    public static UserResponse fromEntity(User user) {
        return UserResponse.builder()
                .nome(user.getNome())
                .email(user.getEmail())
                .build();
    }
}
