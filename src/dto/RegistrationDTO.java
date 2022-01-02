package dto;

import java.time.LocalDate;

public class RegistrationDTO {
    private String registrationId;
    private LocalDate registrationDate;
    private ProgramDTO programDTO;
    private StudentRegistration studentRegistration;

    public RegistrationDTO(String registrationId, LocalDate registrationDate, ProgramDTO programDTO, StudentRegistration studentRegistration) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.programDTO = programDTO;
        this.studentRegistration = studentRegistration;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public void setProgramDTO(ProgramDTO programDTO) {
        this.programDTO = programDTO;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }
}
