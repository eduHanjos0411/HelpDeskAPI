package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Categoria;
import com.dudu.HelpDeskAPI.enums.Prioridade;
import com.dudu.HelpDeskAPI.model.Ticket;

public record TicketResponse(
        String titulo,
        String descricao,
        Categoria categoria,
        Prioridade prioridade,
        Long solicitante
) {

    public TicketResponse(Ticket ticket) {
        this(
                ticket.getTitulo(),
                ticket.getDescricao(),
                ticket.getCategoria(),
                ticket.getPrioridade(),
                ticket.getSolicitante() != null ? ticket.getSolicitante().getId() : null
        );
    }

    public TicketResponse(TicketRequest tr) {
        this(
                tr.titulo(),
                tr.descricao(),
                tr.categoria(),
                tr.prioridade(),
                tr.solicitanteId()
        );
    }
}
