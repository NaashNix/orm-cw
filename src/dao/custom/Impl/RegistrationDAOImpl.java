package dao.custom.Impl;

import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.RegistrationDTO;
import entity.RegistrationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean recordRegistration(RegistrationEntity registrationEntity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(registrationEntity);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public List<RegistrationDTO> getRegistrationForStudent(String studentId) {
        return null;
    }

}
