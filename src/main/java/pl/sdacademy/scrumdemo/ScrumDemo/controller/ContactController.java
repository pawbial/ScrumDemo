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

    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewContact (@RequestBody Contact contact) {
        contactService.saveContact(contact);

    }

    @PutMapping(path = "/edit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void editContact (@RequestBody Contact contact){

        contactService.saveContact(contact);


    }

    @GetMapping(path = "/edit/{id}")
    public String getById(@RequestParam Long id, Model model) {
        Contact contact = contactService.getById(id).get();
        model.addAttribute("contact", contact);
        return "edit";
    }
    @GetMapping(path="/remove")
    public @ResponseBody String remove  (@RequestParam Long id){
        contactService.removeContact(id);
        return "Removed!";
    }



}
