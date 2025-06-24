package com.dudu.HelpDeskAPI.service;

import com.dudu.HelpDeskAPI.dto.ticket.TicketRequest;
import com.dudu.HelpDeskAPI.dto.ticket.TicketResponse;
import com.dudu.HelpDeskAPI.dto.user.UserResponse;
import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.model.User;
import com.dudu.HelpDeskAPI.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    public final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketResponse createNewTicket(TicketRequest dataToCreateTicket) {
        Ticket newTicket = new Ticket();
        newTicket.setTitulo(dataToCreateTicket.titulo());
        newTicket.setDescricao(dataToCreateTicket.descricao());
        newTicket.setStatus(Status.valueOf("ABERTO"));
        newTicket.setCategoria(dataToCreateTicket.categoria());
        newTicket.setPrioridade(dataToCreateTicket.prioridade());
        newTicket.setSolicitante(dataToCreateTicket.solicitante());
        ticketRepository.save(newTicket);

        return new TicketResponse(dataToCreateTicket.titulo(), dataToCreateTicket.descricao(),
                dataToCreateTicket.categoria(), dataToCreateTicket.prioridade(), dataToCreateTicket.solicitante());
    }

    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll().stream().map(TicketResponse::fromEntity).toList();
    }

    public TicketResponse getTicketById(UUID id) {
        Ticket ticketFound = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));

        return new TicketResponse(ticketFound.getTitulo(), ticketFound.getDescricao(), ticketFound.getCategoria(),
                ticketFound.getPrioridade(), ticketFound.getSolicitante());
    }

    public List<TicketResponse> getTicketByUserId(Long id) {
        User ticketOfUserFound = ticketRepository.findById(id);
        for
    }
}
