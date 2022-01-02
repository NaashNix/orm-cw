package dao.custom;

import dao.SuperDAO;
import entity.Programs;

import java.util.List;

public interface ProgramDAO extends SuperDAO {
    boolean addProgram(Programs programs);

    Programs getProgram(String programCode);

    List<Programs> getAllPrograms();

    boolean update(Programs programs);


}
