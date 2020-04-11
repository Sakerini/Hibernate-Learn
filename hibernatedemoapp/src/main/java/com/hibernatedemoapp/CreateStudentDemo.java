package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
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
            Student tempStudent = new Student("Fin", "Philipin", "philipinfin@icloud.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
