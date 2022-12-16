package com.example.spring;

import com.example.spring.exception.NonExistentEventException;
import com.example.spring.exception.NonExistentUserException;
import com.example.spring.model.dto.Category;
import com.example.spring.model.dto.Ticket;
import com.example.spring.model.dto.User;
import com.example.spring.service.BookingService;
import com.example.spring.model.dto.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static com.example.spring.model.dto.Category.CONFERENCES;


@SpringBootTest
class BookingApplicationTests {

	@Autowired
	BookingService bookingService;

	@Test
	void getEvenByIdTest(){
		Event event = bookingService.getEventById(1);
		Assertions.assertEquals("New Event", event.getTitle());
	}

	@Test
	void getEventsByTitleTest(){
		List<Event> eventList = bookingService.getEventsByTitle("event1");
		Assertions.assertEquals( 2, eventList.size());
	}

	@Test
	void getEventsForDayTest(){
		List<Event> eventList = bookingService.getEventsForDay(Date.valueOf("2020-10-01"));
		Assertions.assertEquals( 3, eventList.size());
	}

	@Test
	void createEventTest() {

		Event eventToCreate = Event.builder().title("New Event").build();
		Event eventCreated = bookingService.createEvent(eventToCreate);
		Assertions.assertEquals( "New Event", eventCreated.getTitle());
	}

	@Test
	void updateEventTest() {

		Event eventToUpdate = Event.builder()
							       .id(1L)
				        		   .title("New Event")
				   				   .date(Date.valueOf("2020-12-12"))
							       .build();
		Event eventUpdated = bookingService.updateEvent(eventToUpdate);
		Assertions.assertEquals("New Event", eventUpdated.getTitle());
	}

	@Test
	void updateNonExistingEventTest(){
		Event eventToUpdate = Event.builder()
				.id(11L)
				.title("New Event")
				.date(Date.valueOf("2020-12-12"))
				.build();
		Assertions.assertThrows(NonExistentEventException.class , ()-> bookingService.updateEvent(eventToUpdate));
	}

	@Test
	void deleteNonExistingEventTest() {
		Long eventId = 10L;
		Assertions.assertThrows(NonExistentEventException.class , ()-> bookingService.deleteEvent(eventId));
	}

	@Test
	void getUserByIdTest(){
		Long userId = 1L;
		User user = bookingService.getUserById(userId);
		Assertions.assertEquals("Juan", user.getName());
	}
	@Test
	void getUserByEmailTest(){
		User user = bookingService.getUserByEmail("laura.carmona@epam.com");
		Assertions.assertEquals("laura.carmona@epam.com", user.getEmail());
	}
	@Test
	void getUsersByNameTest(){
		List<User> users = bookingService.getUsersByName("Carlos");
		Assertions.assertEquals(1, users.size());
	}

	@Test
	void createUserTest() {
		User userToCreate = User.builder().name("Carlos").email("carlos@epam.com").build();
		User userCreated = bookingService.createUser(userToCreate);
		Assertions.assertEquals("Carlos", userCreated.getName());
	}

	@Test
	void updateUserTest() {

		User userToUpdate = User.builder()
				.id(1L)
				.name("Juan")
				.email("juan@epam.com")
				.build();
		User userUpdated = bookingService.updateUser(userToUpdate);
		Assertions.assertEquals("Juan", userUpdated.getName());
	}

	@Test
	void updateNonExistingUserTest(){
		User userToUpdate = User.builder()
				.id(11L)
				.name("Laura")
				.email("laura@epam.com")
				.build();
		Assertions.assertThrows(NonExistentUserException.class , ()-> bookingService.updateUser(userToUpdate));
	}

	@Test
	void deleteNonExistingUserTest() {
		Long userId = 10L;
		Assertions.assertThrows(NonExistentUserException.class , ()-> bookingService.deleteUser(userId));
	}

	@Test
	void bookTicketTest(){
		User userToBook = User.builder()
				.id(1L)
				.name("Laura")
				.email("laura@epam.com")
				.build();

		Event eventToBook = Event.builder()
				.id(1L)
				.title("New Event")
				.date(Date.valueOf("2020-12-12"))
				.build();

		int place = 1;

		Ticket ticketBooked =  bookingService.bookTicket(userToBook.getId(), eventToBook.getId(), place, CONFERENCES);

		Assertions.assertEquals(CONFERENCES, ticketBooked.getCategory());
	}
}

