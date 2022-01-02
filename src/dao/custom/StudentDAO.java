package dao.custom;

import dao.SuperDAO;
import entity.Student;

import java.util.List;

public interface StudentDAO extends SuperDAO {
    boolean save(Student student);

    Student getStudent(String studentId);

    boolean update(Student student);

    List<Student> getStudentList();
}
