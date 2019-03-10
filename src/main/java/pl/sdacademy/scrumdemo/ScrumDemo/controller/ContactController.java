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

    @PutMapping(path = "/edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void editContact (@RequestBody Contact contact){

        contactService.editContact(contact);

    }




}
