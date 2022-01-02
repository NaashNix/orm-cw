package dto;

import entity.Programs;

import java.time.LocalDate;
import java.util.Date;

public class StudentRegistration {
    private String studentId;
    private String name;
    private String nic;
    private String address;
    private LocalDate birthday;

    public StudentRegistration(){}

    public StudentRegistration(String studentId, String name, String nic, String address, LocalDate birthday) {
        this.studentId = studentId;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
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
}
