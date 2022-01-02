package util;

import entity.Programs;
import entity.RegistrationEntity;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Properties properties = new Properties();
        try{
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        }catch (Exception e){
            System.out.println("cannot load properties file.");
        }
        sessionFactory = new Configuration().mergeProperties(properties)
                //Add Annotated Classes here.
                .addAnnotatedClass(Programs.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(RegistrationEntity.class)
                .buildSessionFactory();
    }

    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
