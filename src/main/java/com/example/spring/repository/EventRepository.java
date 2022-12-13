package com.example.spring.repository;

import com.example.spring.dao.EventDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventDAO, Long>{
}
