package pl.sdacademy.scrumdemo.ScrumDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.scrumdemo.ScrumDemo.model.Contact;
import pl.sdacademy.scrumdemo.ScrumDemo.service.ContactService;

import java.util.Collection;

@Controller
@RequestMapping
public class ContactController {

    @Autowired
    private ContactService contactService;


    @GetMapping(path = "/list")
    public @ResponseBody Collection<Contact> getAllContacts () {

        return contactService.getAllContacts();

    }

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewContact (@RequestBody Contact contact) {
        contactService.saveContact(contact);

    }


}
