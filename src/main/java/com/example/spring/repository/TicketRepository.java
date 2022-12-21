package com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.dao.TicketDAO;

@Repository
public interface TicketRepository extends JpaRepository<TicketDAO, Long> {

  List<TicketDAO> findTicketByUserId(Long userId);

  List<TicketDAO> findTicketByEventId(Long eventId);
}
