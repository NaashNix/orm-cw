package dao.custom;

import dao.SuperDAO;
import dto.RegistrationDTO;
import entity.RegistrationEntity;

import java.util.List;

public interface RegistrationDAO extends SuperDAO {
    boolean recordRegistration(RegistrationEntity registrationEntity);

    List<RegistrationEntity> getRegistrationForStudent(String studentId);

    boolean recordNewRegistrationWithExistingStudent(RegistrationEntity registrationEntity);
}
