package com.example.spring.repository;

import com.example.spring.dao.EventDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventDAO, Long>{
    List<EventDAO> findEventsByTitle(String title);

    List<EventDAO> findEventsByDate(Date date);
}
