package dto;

import entity.Programs;

import java.time.LocalDate;
import java.util.Date;

public class StudentRegistration {
    private String studentId;
    private String name;
    private LocalDate dateRegistered;
    private String nic;
    private String address;
    private LocalDate birthday;
    private ProgramDTO programDTO;

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", dateRegistered=" + dateRegistered +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", programDTO=" + programDTO +
                '}';
    }

    public StudentRegistration(String studentId, String name, LocalDate dateRegistered, String nic, String address, LocalDate birthday, ProgramDTO programDTO) {
        this.studentId = studentId;
        this.name = name;
        this.dateRegistered = dateRegistered;
        this.nic = nic;
        this.address = address;
        this.birthday = birthday;
        this.programDTO = programDTO;
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

    public ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public void setProgramDTO(ProgramDTO programDTO) {
        this.programDTO = programDTO;
    }
}
