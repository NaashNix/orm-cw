package dao.custom;

import dao.SuperDAO;
import dto.ProgramDTO;
import entity.Programs;

import java.util.ArrayList;
import java.util.List;

public interface ProgramDAO extends SuperDAO {
    public boolean addProgram(Programs programs);

    public Programs getProgram(String programCode);

    public List<Programs> getAllPrograms();
}
