package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // use current session to save the student Object

            // create a three student object
            System.out.println("Creating 3 student object...");
            Student tempStudent1 = new Student("Alexandr", "Chaushev", "hibernate@email.com");
            Student tempStudent2 = new Student("Ilon", "Musk", "MuskIlon@email.com");
            Student tempStudent3 = new Student("Cristiano", "Ronaldo", "CR7@email.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
