package pl.sdacademy.scrumdemo.ScrumDemo.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
}
