package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import entity.Programs;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.PROGRAM);


    @Override
    public boolean save(Programs programs) {
        return programDAO.addProgram(programs);
    }

    @Override
    public boolean checkAvailability(String programCode) {
        Programs program = programDAO.getProgram(programCode);
        return program != null;
    }

    @Override
    public ArrayList<ProgramDTO> getProgramCodes() {
        ArrayList<ProgramDTO> codes = new ArrayList<>();
        List<Programs> allPrograms = programDAO.getAllPrograms();
        for (Programs program : allPrograms ) {
            codes.add(new ProgramDTO(program.getProgramId(),program.getProgramName()));
        }
        return codes;
    }
}
