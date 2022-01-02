package entity;

import javax.persistence.Entity;

@Entity(name = "student_program")
public class RegistrationEntity {

    Student student;
    Programs programs;

}
