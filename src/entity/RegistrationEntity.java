package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "student_program")
public class RegistrationEntity {
    @Id
    private
    String registrationId;
    @ManyToOne
    private
    Student student;
    @ManyToOne
    private
    Programs programs;
    private LocalDate registrationDate;

    public RegistrationEntity(){}

    public RegistrationEntity(String registrationId, Student student, Programs programs, LocalDate registrationDate) {
        this.registrationId = registrationId;
        this.student = student;
        this.programs = programs;
        this.registrationDate = registrationDate;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
