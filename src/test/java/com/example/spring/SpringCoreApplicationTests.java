package com.example.spring;

import com.example.spring.service.BookingService;
import com.example.spring.model.DTO.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringCoreApplicationTests {

	@Autowired
	BookingService bookingService;

	@Test
	void getEvenTest(){
		Event event = bookingService.getEventById(1);
		Assertions.assertEquals("event1", event.getTitle());
	}

	@Test
	void createEventTest() {

		Event eventToCreate = Event.builder().title("New Event").build();
		Event eventCreated = bookingService.createEvent(eventToCreate);
		Assertions.assertEquals(eventCreated.getTitle(), "New Event");
	}

}
