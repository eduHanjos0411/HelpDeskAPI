package com.dudu.HelpDeskAPI.controller;

import com.dudu.HelpDeskAPI.dto.ticket.TicketPutRequest;
import com.dudu.HelpDeskAPI.dto.ticket.TicketRequest;
import com.dudu.HelpDeskAPI.dto.ticket.TicketResponse;
import com.dudu.HelpDeskAPI.enums.Status;
import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.repository.TicketRepository;
import com.dudu.HelpDeskAPI.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    public final TicketService ticketService;
    public final TicketRepository ticketRepository;

    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createNewTicket(@RequestBody TicketRequest dataToNewTicket) {
        ticketService.createNewTicket(dataToNewTicket);

        return ResponseEntity.status(HttpStatus.CREATED).body(new TicketResponse(dataToNewTicket));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        List<TicketResponse> allTickets = ticketService.getAllTickets();

        return ResponseEntity.ok(allTickets);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id) {
        TicketResponse ticketFound = ticketService.getTicketById(id);

        return ResponseEntity.ok(ticketFound);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketResponse>> getTicketsByUserId(@PathVariable Long userId) {
        List<TicketResponse> ticketsFound = ticketService.getTicketByUserId(userId);

        return ResponseEntity.ok(ticketsFound);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponse> updateStatusOrTecnician(@PathVariable Long id, @RequestBody TicketPutRequest newData) {
        Ticket ticketFound = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not Found"));

        ticketService.updateTicketStatusOrTecnician(id, newData);

        return ResponseEntity.ok(new TicketResponse(ticketFound));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TicketResponse> updateStatus(@PathVariable Long id, @RequestBody Status newStatus) {
        Ticket ticketFound = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not Found"));

        ticketService.updateTicketStatus(id, newStatus);

        return ResponseEntity.ok(new TicketResponse(ticketFound));
    }


}
