package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.User;

public record TicketPutRequest(
        Long id,
        Status status,
        User responsavel
)
{}
