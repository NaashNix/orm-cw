package dao.custom;

import dao.SuperDAO;
import dto.RegistrationDTO;
import entity.RegistrationEntity;

import java.util.List;

public interface RegistrationDAO extends SuperDAO {
    boolean recordRegistration(RegistrationEntity registrationEntity);

    List<RegistrationDTO> getRegistrationForStudent(String studentId);
}