package com.example.spring.model.dto;

import com.example.spring.model.EventI;
import com.example.spring.model.UserI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private Long id;
    private User user;
    private Event event;
    private Category category;
    private int place;
}
