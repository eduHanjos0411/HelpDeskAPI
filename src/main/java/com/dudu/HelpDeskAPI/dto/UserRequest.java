package com.dudu.HelpDeskAPI.dto;

public record UserRequest(
        String nome,
        String email,
        String senha
) {
}
