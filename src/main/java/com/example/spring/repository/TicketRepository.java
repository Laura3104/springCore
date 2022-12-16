package com.example.spring.repository;

import com.example.spring.dao.EventDAO;
import com.example.spring.dao.TicketDAO;
import com.example.spring.dao.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketDAO, Long> {

    List<TicketDAO> findTicketByUser(UserDAO userDAO);

    List<TicketDAO> findTicketByEvent(EventDAO eventDAO);
}
