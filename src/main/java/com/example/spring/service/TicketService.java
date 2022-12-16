package com.example.spring.service;

import com.example.spring.dao.EventDAO;
import com.example.spring.dao.TicketDAO;
import com.example.spring.dao.UserDAO;
import com.example.spring.model.dto.Category;
import com.example.spring.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    TicketRepository ticketRepository;

    public TicketDAO bookTicket(long userId, long eventId, int place, Category category) {
        EventDAO eventDAO = eventService.getEventById(eventId);
        UserDAO userDAO = userService.getUserById(userId);

        TicketDAO ticketDAO = TicketDAO.builder()
                                       .user(userDAO)
                                       .event(eventDAO)
                                       .place(place)
                                       .category(category.toString())
                                       .build();

        return ticketRepository.save(ticketDAO);
    }

    public List<TicketDAO> getBookedTickets(UserDAO user) {
        return ticketRepository.findTicketByUser(user);
    }

    public List<TicketDAO> getBookedTickets(EventDAO event) {
        return ticketRepository.findTicketByEvent(event);
    }

    public void cancelTicket(long ticketId) {
       ticketRepository.deleteById(ticketId);
    }
}
