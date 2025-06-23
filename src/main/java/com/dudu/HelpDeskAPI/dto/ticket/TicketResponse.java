package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Categoria;
import com.dudu.HelpDeskAPI.enums.Prioridade;
import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.model.User;
import lombok.Builder;

@Builder
public record TicketResponse(
        String titulo,
        String descricao,
        Categoria categoria,
        Prioridade prioridade,
        User solicitante
) {

    public static TicketResponse fromEntity(Ticket ticket) {
        return TicketResponse.builder()
                .titulo(ticket.getTitulo())
                .descricao(ticket.getDescricao())
                .categoria(ticket.getCategoria())
                .prioridade(ticket.getPrioridade())
                .solicitante(ticket.getSolicitante())
                .build();
    }
}
