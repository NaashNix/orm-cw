package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    String studentId;
    String name;
    String dateRegistered;
    String nic;
    String address;
    Date birthday;
    @ManyToMany
    List<Programs> programsList;

}
