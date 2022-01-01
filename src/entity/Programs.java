package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Programs {
    @Id
    String programId;
    String programName;
    int Duration;
    String duration_type;
    BigDecimal programFee;
    @ManyToMany(mappedBy = "programList")
    List<Student> studentList;

}
