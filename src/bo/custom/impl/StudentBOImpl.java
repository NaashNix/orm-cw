package bo.custom.impl;

import bo.BOFactory;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.RegistrationDTO;
import entity.Student;
import view.tdm.StudentDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StudentBOImpl implements StudentBO {
    private ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.PROGRAM);
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.STUDENT);
    private RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.REGISTRATION);
    @Override
    public boolean save(RegistrationDTO registrationDTO) {
        Student student = new Student();
        student.setNic(registrationDTO.getStudentRegistration().getNic());
        student.setName(registrationDTO.getStudentRegistration().getName());
        student.setStudentId(registrationDTO.getStudentRegistration().getNic());
        student.setAddress(registrationDTO.getStudentRegistration().getAddress());
        student.setBirthday(registrationDTO.getStudentRegistration().getBirthday());
        student.setDateRegistered(LocalDate.now());
        studentDAO.save(student);
        boolean save = registrationBO.save(registrationDTO);
        return false;
    }

    @Override
    public List<StudentDetails> getStudentList() {
        List<StudentDetails> studentDetails = new ArrayList<>();
        List<Student> studentList = studentDAO.getStudentList();
        for (Student s:studentList
             ) {
            studentDetails.add(new StudentDetails(s.getStudentId(),s.getName(),s.getAddress(),s.getNic()));
        }
        return studentDetails;
    }

}
