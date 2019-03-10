package pl.sdacademy.scrumdemo.ScrumDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.scrumdemo.ScrumDemo.model.Contact;
import pl.sdacademy.scrumdemo.ScrumDemo.repository.ContactRepository;

import java.util.Collection;

@Service


public class ContactService {


    @Autowired
    private ContactRepository contactRepository;




    public Collection<Contact> getAllContacts () {

        return (Collection<Contact>) contactRepository.findAll();
    }

    public void saveContact (Contact contact) {

        contactRepository.save(contact);
    }

    public void editContact(Contact contact){

        contactRepository.save(contact);
    }

    public void removeContact(Long id){

        contactRepository.deleteById(id);
    }

}
