package dto;

import java.time.LocalDate;

public class ANReWExStnd {
    private String registrationId;
    private LocalDate registrationDate;
    private String programCode;
    private String studentId;

    public ANReWExStnd(String registrationId, LocalDate registrationDate, String programCode, String studentId) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.programCode = programCode;
        this.studentId = studentId;
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

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
