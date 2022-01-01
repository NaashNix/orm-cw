package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;
import entity.Programs;

public interface ProgramBO extends SuperBO {
    public boolean save(Programs programs);

    public boolean checkAvailability(String programCode);
}
