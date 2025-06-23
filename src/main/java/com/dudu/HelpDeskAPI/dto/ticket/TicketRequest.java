package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Categoria;
import com.dudu.HelpDeskAPI.enums.Prioridade;
import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.User;

public record TicketRequest(
        String titulo,
        String descricao,
        Status status,
        Categoria categoria,
        Prioridade prioridade,
        User solicitante
) {
}
