package com.dudu.HelpDeskAPI.dto.user;

import com.dudu.HelpDeskAPI.enums.Perfil;
import com.dudu.HelpDeskAPI.enums.Status;

public record UserRequest(
        String nome,
        String email,
        String senha,
        Perfil perfil
) {
}
