package com.example.spring.repository;

import com.example.spring.dao.TicketDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDAO, Long> {
}
