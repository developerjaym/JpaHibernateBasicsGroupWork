package org.example.jaystuff.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SCHOOL_DATA")
@Getter
@Setter
public class School {
    @Id
    private int id;
    private String name;
}
