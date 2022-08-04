package org.example.jaystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private boolean isActive;

    //mappedBy says put the foreign key over in the other table
    @OneToOne(mappedBy = "idCard", cascade = CascadeType.REMOVE) // The Student class will have a column with a
    // foreign key to IDCard
    private Student student;
    // if student is deleted, then I want the idcard deleted, too.
    // if I delete an idcard, I DO NOT want my student deleted
}
