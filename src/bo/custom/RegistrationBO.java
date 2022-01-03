package bo.custom;

import bo.SuperBO;
import dto.ANReWExStnd;
import dto.RegistrationDTO;
import view.tdm.ProgramTDM;

import java.util.List;

public interface RegistrationBO extends SuperBO {
    boolean save(RegistrationDTO registrationDTO);

    List<ProgramTDM> getProgramDetails(String studentId);

    boolean saveNewRegistration(ANReWExStnd record);
}
