package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // use current session to save the student Object

            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Marco", "Reus", "Reus@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // find out the student's id: primary key
            System.out.println("Save student, Generated id: " + tempStudent.getId());

            // now get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the student based on id:pk
            System.out.println("\nGetting student with the id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete " + myStudent);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
