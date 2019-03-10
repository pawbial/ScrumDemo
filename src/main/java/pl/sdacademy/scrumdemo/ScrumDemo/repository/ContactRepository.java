package pl.sdacademy.scrumdemo.ScrumDemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.scrumdemo.ScrumDemo.model.Contact;

public interface ContactRepository extends CrudRepository <Contact, Long> {
}
