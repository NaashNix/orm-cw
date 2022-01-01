package dao;

import dao.custom.Impl.ProgramDAOImpl;

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
            default:
                return null;

        }
    }

    public enum daoTypes{
        PROGRAM,STUDENT
    }
}
