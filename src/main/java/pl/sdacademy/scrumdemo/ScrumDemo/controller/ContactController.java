package pl.sdacademy.scrumdemo.ScrumDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.scrumdemo.ScrumDemo.model.Contact;
import pl.sdacademy.scrumdemo.ScrumDemo.service.ContactService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class ContactController {

    @Autowired
    private ContactService contactService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/list")
    public String getAllContacts (Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "list";
    }

    @GetMapping(path = "/add")
    public @ResponseBody String addNewContact (@RequestParam String firstName, @RequestParam String lastName,
                                               @RequestParam String phoneNumber, @RequestParam String email) {
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhoneNumber(phoneNumber);
        contactService.saveContact(contact);
        return "Saved!";
    }


}
