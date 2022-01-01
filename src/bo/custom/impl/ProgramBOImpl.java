package bo.custom.impl;

import bo.custom.ProgramBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dto.ProgramDTO;

public class ProgramBOImpl implements ProgramBO {
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.PROGRAM);


    @Override
    public boolean save(ProgramDTO programDTO) {
        return programDAO.addProgram(programDTO);
    }
}
