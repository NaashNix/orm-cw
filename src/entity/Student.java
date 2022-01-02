package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
public class Student {
    @Id
    private String studentId;
    private String name;
    private LocalDate dateRegistered;
    private String nic;
    private String address;
    private LocalDate birthday;
    @OneToMany(mappedBy = "student" , fetch = FetchType.EAGER)
    private List<RegistrationEntity> registration = new ArrayList<>();

    public Student() {
    }

    public Student(String studentId, String name, LocalDate dateRegistered, String nic, String address, LocalDate birthday, List<RegistrationEntity> registration) {
        this.setStudentId(studentId);
        this.setName(name);
        this.setDateRegistered(dateRegistered);
        this.setNic(nic);
        this.setAddress(address);
        this.setBirthday(birthday);
        this.setRegistration(registration);
    }

    public Student(String studentId, String name, LocalDate dateRegistered, String nic, String address, LocalDate birthday) {
        this.setStudentId(studentId);
        this.setName(name);
        this.setDateRegistered(dateRegistered);
        this.setNic(nic);
        this.setAddress(address);
        this.setBirthday(birthday);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<RegistrationEntity> getRegistration() {
        return registration;
    }

    public void setRegistration(List<RegistrationEntity> registration) {
        this.registration = registration;
    }
}
