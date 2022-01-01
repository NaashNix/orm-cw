package dao.custom;

import dao.SuperDAO;
import dto.ProgramDTO;
import entity.Programs;

public interface ProgramDAO extends SuperDAO {
    public boolean addProgram(Programs programs);

    public Programs getProgram(String programCode);
}
