package org.example.jaystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT_DATA")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PrimaryTeacher primaryTeacher;
    @Temporal(TemporalType.DATE)
    private Date dob;
    // The Student class will have a column with a foreign key to IDCard
    // The IDCard data will ONLY be fetched when I do someStudent.getIdCard();
    @OneToOne(fetch = FetchType.LAZY) // EAGER is the opposite and EAGER is the default
    private IDCard idCard;

    @ManyToOne(fetch = FetchType.LAZY) // The student will have a column with a foreign key to Dorm
    private Dorm dorm;


    @ManyToMany(mappedBy = "students") //bidirectional
    private List<Course> courses = new ArrayList<>();


}
