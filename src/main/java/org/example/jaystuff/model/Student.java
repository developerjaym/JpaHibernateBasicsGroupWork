package org.example.jaystuff.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STUDENT_DATA")
@Getter
@Setter
public class Student {
    @Id
    private int id;
    private String email; //varchar(255)
    private String name;
    @Enumerated(EnumType.STRING)
    private PrimaryTeacher primaryTeacher;
    @Temporal(TemporalType.DATE)
    private Date dob;

}
