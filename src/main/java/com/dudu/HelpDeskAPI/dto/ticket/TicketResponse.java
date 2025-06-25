package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Categoria;
import com.dudu.HelpDeskAPI.enums.Prioridade;
import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.model.User;

import java.time.LocalDateTime;


public record TicketResponse(
        String titulo,
        String descricao,
        Categoria categoria,
        Prioridade prioridade,
        User solicitante,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {

    public TicketResponse(Ticket ticket) {
        this(
                ticket.getTitulo(),
                ticket.getDescricao(),
                ticket.getCategoria(),
                ticket.getPrioridade(),
                ticket.getSolicitante(),
                ticket.getCriadoEm(),
                ticket.getAtualizadoEm()
        );
    }
}
