package com.dudu.HelpDeskAPI.repository;

import com.dudu.HelpDeskAPI.model.Ticket;
import com.dudu.HelpDeskAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    User findById(Long id);
}
