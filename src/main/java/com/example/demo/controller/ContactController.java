package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    // Route for displaying the search form
    @GetMapping("/")
    public String showSearchForm() {
        return "search"; // This will render search.html
    }

    // Route to search for contacts by city
    @GetMapping("/search")
    public String searchContactsByCity(@RequestParam("city") String city, Model model) {
        List<Contact> contacts = contactRepository.findByCity(city);
        model.addAttribute("contacts", contacts);
        return "search"; // Reuse search.html to display results
    }
}
