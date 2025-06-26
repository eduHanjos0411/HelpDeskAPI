package com.dudu.HelpDeskAPI.dto.user;

import com.dudu.HelpDeskAPI.enums.Perfil;


public record UserRequest(
        String nome,
        String email,
        String senha,
        Perfil perfil
) {
}
