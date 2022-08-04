package org.example.jaystuff;

import org.example.jaystuff.model.Course;
import org.example.jaystuff.model.Dorm;
import org.example.jaystuff.model.IDCard;
import org.example.jaystuff.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Predicate;

public class Phase2Main {
    public static void main(String[] args) {
        // create student instances
        Student student1 = new Student();
        student1.setName("Jack");
        student1.setDob(new Date());

        Student student2 = new Student();
        student2.setName("Leslie");
        student2.setDob(new Date());

        // create id cards
        IDCard card1 = new IDCard();
        card1.setActive(true);

        IDCard card2 = new IDCard();
        card2.setActive(false);

        // create dorms
        Dorm dorm1 = new Dorm();
        dorm1.setAddress("500 N Martin Jischke Drive");


        // create student-card associations
        // From the below, Hibernate can figure out how to insert the student and card
        // and set the foreign key properly
        student1.setIdCard(card1);
        student2.setIdCard(card2);

        // create dorm -< students associations
        student1.setDorm(dorm1);
        student2.setDorm(dorm1);

        dorm1.getStudents().add(student1);
        dorm1.getStudents().add(student2);

        // create courses
        Course course1 = new Course();
        course1.setName("Arts and Crafts");
        Course course2 = new Course();
        course2.setName("Reading");
        Course course3 = new Course();
        course3.setName("Math");

        // create students >-< courses association
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        course1.getStudents().add(student1);
        course2.getStudents().add(student1);

        student2.getCourses().add(course2);
        student2.getCourses().add(course3);
        course2.getStudents().add(student2);
        course3.getStudents().add(student2);

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student studentFromEntityManager = entityManager.find(Student.class, 6);
        // Everything is eager!
        // SELECT * FROM student_data s
        // LEFT OUTER JOIN idcard i on i.id = s.idcard_id
        // LEFT OUTER JOIN dorm d on d.id = s.dorm_id
        // WHERE s.id = 6;

//        System.out.println(studentFromEntityManager.getDorm().getStudents());


        System.out.println("Welcome " + studentFromEntityManager.getName());

        //        select * from STUDENT_DATA s LEFT OUTER JOIN dorm d on d.id = s.dorm_id where s.id = 6;


        System.out.println(studentFromEntityManager.getIdCard());
        // When trying to get ID Card in Java, Hibernate will then know it needs to run this query
        // The Java line above will produce the query written below
        // select * from STUDENT_DATA s LEFT OUTER JOIN IDCARD i on i.id = s.idcard_id; -- I'm slow!


        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        // create and use transactions
        transaction.begin();
        entityManager.persist(dorm1);

        entityManager.persist(student1);
        entityManager.persist(student2);

        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(course1);
        entityManager.persist(course2);
        entityManager.persist(course3);

        // CASCADE
//        Student deleteMe = entityManager.find(Student.class, 4);
//        entityManager.remove(deleteMe);

        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
