package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import dto.StudentRegistration;
import entity.Programs;

import java.util.ArrayList;
import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean save(Programs programs);

    boolean checkAvailability(String programCode);

    public List<ProgramDTO> getProgramCodes();

    public ArrayList<ProgramDTO> getProgramDTO();
}
