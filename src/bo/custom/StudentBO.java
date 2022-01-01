package bo.custom;

import bo.SuperBO;
import dto.StudentRegistration;

public interface StudentBO extends SuperBO {
    public boolean save(StudentRegistration student);


}
