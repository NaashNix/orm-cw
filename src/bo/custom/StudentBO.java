package bo.custom;

import bo.SuperBO;
import dto.RegistrationDTO;
import dto.StudentRegistration;
import view.tdm.StudentDetails;

import java.util.List;

public interface StudentBO extends SuperBO {

    boolean save(RegistrationDTO registrationDTO);

    List<StudentDetails> getStudentList();
}
