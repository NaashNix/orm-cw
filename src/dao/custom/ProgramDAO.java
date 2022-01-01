package dao.custom;

import dao.SuperDAO;
import dto.ProgramDTO;

public interface ProgramDAO extends SuperDAO {
    public boolean addProgram(ProgramDTO programDTO);
}
