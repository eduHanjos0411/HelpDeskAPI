package com.dudu.HelpDeskAPI.service;

import com.dudu.HelpDeskAPI.dto.ticket.TicketRequest;
import com.dudu.HelpDeskAPI.dto.ticket.TicketResponse;
import com.dudu.HelpDeskAPI.dto.ticket.TicketPutRequest;
import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

        return new TicketResponse(newTicket);
    }

    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll().stream().map(TicketResponse::new).toList();
    }

    public TicketResponse getTicketById(Long id) {
        Ticket ticketFound = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not Found"));

        return new TicketResponse(ticketFound.getTitulo(), ticketFound.getDescricao(), ticketFound.getCategoria(),
                ticketFound.getPrioridade(), ticketFound.getSolicitante(), ticketFound.getCriadoEm(),
                ticketFound.getAtualizadoEm());
    }

    public List<TicketResponse> getTicketByUserId(Long userId) {
        return ticketRepository.findBySolicitanteId(userId).stream().map(TicketResponse::new).toList();
    }

    public TicketResponse updateTicketStatusOrTecnician(TicketPutRequest newData) {
        Ticket ticketToUpdate = ticketRepository.findById(newData.id())
                .orElseThrow(() -> new RuntimeException("Ticket not Found"));

        ticketToUpdate.setStatus(newData.status());
        ticketToUpdate.setResponsavel(newData.responsavel());

        ticketRepository.save(ticketToUpdate);

        return new TicketResponse(ticketToUpdate);
    }

    public TicketResponse updateTicketStatus( Long id,Status newStatus) {
        Ticket toUpdateStatus = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not Found"));

        toUpdateStatus.setStatus(newStatus);

        ticketRepository.save(toUpdateStatus);

        return new TicketResponse(toUpdateStatus);
    }
}
