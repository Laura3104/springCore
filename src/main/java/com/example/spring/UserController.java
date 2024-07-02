package com.example.spring;

import com.example.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("list/{id}")
    public String users(@PathVariable("id") long id, Model model){
        model.addAttribute("users", this.bookingService.getUserById(id));
        return "index";
    }
}
