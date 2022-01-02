package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import entity.Programs;

import java.util.ArrayList;
import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean save(Programs programs);

    public boolean checkAvailability(String programCode);

    public List<ProgramDTO> getProgramCodes();
}
