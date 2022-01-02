package dao;

import dao.custom.Impl.ProgramDAOImpl;
import dao.custom.Impl.StudentDAOImpl;

public class DAOFactory implements SuperDAO{
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(daoTypes daoTypes){
        switch (daoTypes) {
            case PROGRAM:
                return new ProgramDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;

        }
    }

    public enum daoTypes{
        PROGRAM,STUDENT
    }
}
