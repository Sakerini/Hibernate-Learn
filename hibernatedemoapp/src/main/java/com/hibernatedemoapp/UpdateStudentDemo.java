package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;



            // now get a new session and start a transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve the student based on id:pk
            System.out.println("\nGetting student with the id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");

            myStudent.setFirstName("Alex"); // Updating name of the 1st id student object to Alex...

            // commit the transaction
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            //update emails from email to gmail
            session.createQuery("update Student set email='test@gmail.com'").executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }
}
