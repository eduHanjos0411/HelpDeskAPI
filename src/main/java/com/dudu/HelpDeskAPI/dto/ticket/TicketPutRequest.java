package com.dudu.HelpDeskAPI.dto.ticket;

import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.User;

public record TicketPutRequest(
        Status status,
        Long responsavelId
)
{}
