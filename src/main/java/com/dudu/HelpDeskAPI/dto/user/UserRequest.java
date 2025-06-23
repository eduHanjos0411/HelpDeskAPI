package com.dudu.HelpDeskAPI.dto.user;

public record UserRequest(
        String nome,
        String email,
        String senha
) {
}
