package com.example.spring.dao;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
@Entity
public class TicketDAO {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "category")
  private String category;

  @Column(name = "place")
  private int place;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserDAO user;

  @ManyToOne
  @JoinColumn(name = "event_id", nullable = false)
  private EventDAO event;
}
