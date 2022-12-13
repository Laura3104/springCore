package com.example.spring.service;

import com.example.spring.dao.EventDAO;
import com.example.spring.exception.NonExistentEventException;
import com.example.spring.model.DTO.Event;
import com.example.spring.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public EventDAO getEventById(long eventId) {
        log.info("Getting event by Id: " + eventId);
        return eventRepository.findById(eventId).orElseThrow(NonExistentEventException::new);
    }

/*    public List<EventDAO> getEventsByTitle(String title, int pageSize, int pageNum) {
        eventRepository.findBy();
        return ;
    }


    public List<EventDAO> getEventsForDay(Date day, int pageSize, int pageNum) {
        return ;
    }*/

    public EventDAO createEvent(Event event) {

        EventDAO eventToSave = new EventDAO();
        eventToSave.setTitle(event.getTitle());
        eventToSave.setDate(event.getDate());

        return eventRepository.save(eventToSave);
    }

    public EventDAO updateEvent(Event event) {

        EventDAO eventToUpdate = getEventById(event.getId());
        eventToUpdate.setTitle(event.getTitle());
        eventToUpdate.setDate(event.getDate());

        return eventRepository.save(eventToUpdate);
    }

    public void deleteEvent(long eventId) {
        EventDAO eventToDelete = getEventById(eventId);
        eventRepository.deleteById(eventToDelete.getId());
    }

}
