package com.example.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.dao.EventDAO;

@Repository
public interface EventRepository extends JpaRepository<EventDAO, Long> {
  List<EventDAO> findEventsByTitle(String title);

  List<EventDAO> findEventsByDate(Date date);
}
