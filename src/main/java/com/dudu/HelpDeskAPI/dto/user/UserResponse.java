package com.dudu.HelpDeskAPI.dto.user;

import com.dudu.HelpDeskAPI.model.User;
import lombok.Builder;

@Builder
public record UserResponse(
        String nome,
        String email
) {

    public UserResponse (User u) {
        this(
                u.getNome(),
                u.getEmail()
        );
    }

    public UserResponse(UserRequest ur) {
        this(
                ur.nome(),
                ur.email()
        );
    }
}
