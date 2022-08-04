package org.example.jaystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String address;

    @OneToMany(mappedBy = "dorm")  // The student will have a column with a foreign key to Dorm
    private List<Student> students = new ArrayList<>();
}
