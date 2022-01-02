package bo.custom.impl;

import bo.BOFactory;
import bo.custom.ProgramBO;
import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.StudentDAO;
import dto.ProgramDTO;
import dto.StudentRegistration;
import entity.Programs;
import entity.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StudentBOImpl implements StudentBO {
    private ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.PROGRAM);
    private StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.STUDENT);

    @Override
    public boolean save(StudentRegistration studentDTO) {
        Programs program = programDAO.getProgram(studentDTO.getProgramDTO().getProgramId());
        System.out.println(program.getProgramId()+" : "+program.getProgramName());
        Student student = new Student();
        student.setAddress(studentDTO.getAddress());
        student.setStudentId(studentDTO.getStudentId());
        student.setName(studentDTO.getName());
        student.setNic(studentDTO.getNic());
        student.setDateRegistered(studentDTO.getDateRegistered());

        return false;
    }

}
