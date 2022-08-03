package org.example.jaystuff;

import org.example.jaystuff.model.PrimaryTeacher;
import org.example.jaystuff.model.Student;
import org.example.shared.io.UserInputService;
import org.example.shared.io.UserOutputService;
import org.example.shared.io.console.ConsoleUserInputServiceImpl;
import org.example.shared.io.console.ConsoleUserOutputServiceImpl;
import org.example.shared.io.validation.NonBlankInputValidationRule;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
//        UserOutputService userOutputService = new ConsoleUserOutputServiceImpl();
//        try (UserInputService userInputService = new ConsoleUserInputServiceImpl(userOutputService)) {
//            userOutputService.print("WELCOME");
//            String response = userInputService.getUserInput("What's the student name?",
//                    new NonBlankInputValidationRule());

            // Part 1 - Get H2 database working
            // Part 1B - Add a row to STUDENT_DATA via the H2 console
            // Part 1C - Make a Student class that matches the STUDENT_DATA table

            // Part 1D - create a new student instance
//            Student student1 = new Student();
//            student1.setId(new Random().nextInt());
//            student1.setName("Abdella");
//            student1.setEmail(
//                    "aa" +
//                            "@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//            student1.setDob(Date.from(Instant.now()));
//            student1.setPrimaryTeacher(PrimaryTeacher.JAY);

            // create EntityManager (copy paste this when needed)
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            // access transaction object (copy paste this when needed)
            EntityTransaction transaction = entityManager.getTransaction();

            // create and use transactions (copy paste this when needed)
//            transaction.begin();
//            // do whatever here
//            transaction.commit();
//            EntityTransaction transaction2 = entityManager.getTransaction();
//            transaction2.begin();
//            // do whatever
//            transaction2.commit();
            // Part 1D - Insert
//            entityManager.persist(student1); // IMPORTANT!
        // In Hibernate's brain
        // If student is new to my STUDENT_DATA table, then generate INSERT SQL
        // Else, generate UPDATE SQL

            // Part 2a - Find (by ID)
//            Student student = entityManager.find(Student.class, 1491002700);
//            student.setName("Jay");
//            student.setId(1);
//            System.out.println(student.getName());
//            entityManager.persist(student);

            // Part 2b - Find (with native query) (please note the strange HQL syntax)
//            TypedQuery<Student> studentResult = entityManager.createQuery("select S from Student S where S.name " +
//                            "= 'Conner'",
//                    Student.class);
//            Student student = studentResult.getResultList().get(0);
//            System.out.println(student.getName());
            // Part 3 - Update
//            Student student = entityManager.find(Student.class, 1);
//            student.setName("updated name2");
//            entityManager.persist(student);
            // Part 4 - Delete
//            Student student = entityManager.find(Student.class, 1491002700);
//            entityManager.remove(student);
            // What SQL statements will be generated


            // Part 5 - Exceptions?
            // Let's write code to insert a student but then do something to cause an exception
//            if(student.getName().equals("Sabrina")) {
//                throw new IllegalArgumentException();
//            }

            // commit your transaction (copy paste this when needed)
            transaction.commit();

//        }
    }
}

enum Example {
    YES, NO
}