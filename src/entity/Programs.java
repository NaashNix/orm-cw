package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Programs {
    @Id
    private
    String programId;
    private String programName;
    private int Duration;
    private String duration_type;
    private BigDecimal programFee;
    @ManyToMany(mappedBy = "programList")
    private List<Student> studentList;

    public Programs(String programId, String programName, int duration, String duration_type, BigDecimal programFee) {
        this.programId = programId;
        this.programName = programName;
        Duration = duration;
        this.duration_type = duration_type;
        this.programFee = programFee;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public String getDuration_type() {
        return duration_type;
    }

    public void setDuration_type(String duration_type) {
        this.duration_type = duration_type;
    }

    public BigDecimal getProgramFee() {
        return programFee;
    }

    public void setProgramFee(BigDecimal programFee) {
        this.programFee = programFee;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
