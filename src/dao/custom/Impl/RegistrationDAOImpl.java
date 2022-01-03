package dao.custom.Impl;

import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.RegistrationDTO;
import entity.RegistrationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.ArrayList;
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
    public List<RegistrationEntity> getRegistrationForStudent(String studentId) {
//        List<RegistrationEntity> registrationDTOS = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM student_program WHERE student.studentId=:studentId");
        query.setParameter("studentId",studentId);
        List<RegistrationEntity> RegistrationList = query.list();
        transaction.commit();
        session.close();

        return RegistrationList;
    }

}
