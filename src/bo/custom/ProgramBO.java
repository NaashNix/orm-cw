package bo.custom;

import bo.SuperBO;
import dto.ProgramDTO;

public interface ProgramBO extends SuperBO {
    public boolean save(ProgramDTO programDTO);
}
