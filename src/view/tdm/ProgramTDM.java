package view.tdm;

public class ProgramTDM {
    private String programId;
    private String programName;
    private String registeredDate;
    private String programDuration;

    public ProgramTDM(String programId, String programName, String registeredDate, String programDuration) {
        this.programId = programId;
        this.programName = programName;
        this.registeredDate = registeredDate;
        this.programDuration = programDuration;
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

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }
}
