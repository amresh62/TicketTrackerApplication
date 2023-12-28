package com.greatlearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByTitleContainingIgnoreCase(String title);

    // Search by short description
    List<Ticket> findByDescriptionContainingIgnoreCase(String shortDesc);
}
