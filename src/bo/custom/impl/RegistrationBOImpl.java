package bo.custom.impl;

import bo.custom.ProgramBO;
import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.custom.ProgramDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import dto.ANReWExStnd;
import dto.RegistrationDTO;
import entity.Programs;
import entity.RegistrationEntity;
import entity.Student;
import view.tdm.ProgramTDM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.STUDENT);
    private final ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.PROGRAM);
    private final RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.daoTypes.REGISTRATION);

    @Override
    public boolean save(RegistrationDTO registrationDTO) {
        Student student = studentDAO.getStudent(registrationDTO.getStudentRegistration().getStudentId());
        Programs program = programDAO.getProgram(registrationDTO.getProgramDTO().getProgramId());
        RegistrationEntity entity = new RegistrationEntity();
        entity.setPrograms(program);
        entity.setStudent(student);
        entity.setRegistrationDate(LocalDate.now());
        entity.setRegistrationId(registrationDTO.getRegistrationId());

        student.getRegistration().add(entity);
        studentDAO.update(student);

        program.getRegistrations().add(entity);
        programDAO.update(program);

        boolean b = registrationDAO.recordRegistration(entity);
        System.out.println(b);
        return false;
    }

    @Override
    public List<ProgramTDM> getProgramDetails(String studentId) {
        List<RegistrationEntity> registrationForStudent = registrationDAO.getRegistrationForStudent(studentId);
        List<ProgramTDM> programTDMList = new ArrayList<>();
        if (registrationForStudent == null){
            System.out.println("registrationForStudent : NULL");
            return null;
        }else{
            for (RegistrationEntity r: registrationForStudent
            ) {
                Programs program = programDAO.getProgram(r.getPrograms().getProgramId());
                programTDMList.add(new ProgramTDM(program.getProgramId(),program.getProgramName(),
                        r.getRegistrationDate().toString(),program.getDuration()+
                        " "+program.getDuration_type()));
            }
            return programTDMList;
        }

    }

    @Override
    public boolean saveNewRegistration(ANReWExStnd record) {
        Programs program = programDAO.getProgram(record.getProgramCode());
        Student student = studentDAO.getStudent(record.getStudentId());
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setRegistrationId(record.getRegistrationId());
        registrationEntity.setRegistrationDate(record.getRegistrationDate());
        student.getRegistration().add(registrationEntity);
        program.getRegistrations().add(registrationEntity);
        registrationEntity.setStudent(student);
        registrationEntity.setPrograms(program);
        studentDAO.update(student);
        programDAO.update(program);
        return registrationDAO.recordNewRegistrationWithExistingStudent(registrationEntity);
    }
}
