package com.example.spring.model.DTO;

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
    private UserI user;
    private EventI event;
    private String category;
    private String place;
}
