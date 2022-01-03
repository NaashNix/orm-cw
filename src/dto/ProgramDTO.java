package dto;

import java.math.BigDecimal;

public class ProgramDTO {
    private String programId;
    private String programName;
    private int Duration;
    private String duration_type;
    private BigDecimal programFee;

    public ProgramDTO(String programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }

    public ProgramDTO(String programId, String programName, int duration, String duration_type) {
        this.programId = programId;
        this.programName = programName;
        this.Duration = duration;
        this.duration_type = duration_type;
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
}
