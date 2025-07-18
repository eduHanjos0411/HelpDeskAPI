package com.dudu.HelpDeskAPI.repository;

import com.dudu.HelpDeskAPI.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findBySolicitanteId(Long id);
}
