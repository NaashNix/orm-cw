package dao.custom.Impl;

import dao.custom.ProgramDAO;
import entity.Programs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean addProgram(Programs programs) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(programs);
        transaction.commit();
        return save != null;
    }

    @Override
    public Programs getProgram(String programCode) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Programs program = session.get(Programs.class, programCode);
        transaction.commit();
        return program;
    }

    @Override
    public List<Programs> getAllPrograms() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_programs = session.createQuery("FROM Programs");
        List<Programs> programsList =  from_programs.list();
        transaction.commit();
        return programsList;
    }
}
