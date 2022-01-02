package view.tdm;

public class StudentDetails {
    private String studentId;
    private String name;
    private String address;
    private String nic;

    public StudentDetails(String studentId, String name, String address, String nic) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.nic = nic;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
