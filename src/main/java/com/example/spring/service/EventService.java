package com.example.spring.service;

import com.example.spring.dao.EventDAO;
import com.example.spring.exception.NonExistentEventException;
import com.example.spring.model.dto.Event;
import com.example.spring.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;


@Service
@Slf4j
public class EventService {

    @Autowired
    private EventRepository eventRepository;


    public EventDAO getEventById(long eventId) {
        log.info("Getting event by Id: " + eventId);
        return eventRepository.findById(eventId).orElseThrow(NonExistentEventException::new);
    }

    public List<EventDAO> getEventsByTitle(String title) {
        return eventRepository.findEventsByTitle(title);
    }

    public List<EventDAO> getEventsForDay(Date day) {
        return eventRepository.findEventsByDate(day);
    }

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
