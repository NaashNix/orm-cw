package dao.custom.Impl;

import dao.custom.ProgramDAO;
import dto.ProgramDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.io.Serializable;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean addProgram(ProgramDTO programDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(programDTO);
        transaction.commit();
        return save != null;
    }
}
