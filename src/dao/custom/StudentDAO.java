package dao.custom;

import dao.SuperDAO;
import entity.Student;

public interface StudentDAO extends SuperDAO {
    boolean save(Student student);
}
