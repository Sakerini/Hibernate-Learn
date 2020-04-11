package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // use current session to save the student Object

            // start a transaction
            session.beginTransaction();

            // query the students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the students
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Chaushev'").getResultList();
            System.out.println("The students with last name Chaushev");
            // display the students
            displayStudents(theStudents);

            theStudents = session
                    .createQuery("from Student s where s.firstName='Alexandr' OR s.firstName='Fin'").getResultList();

            //display the students
            displayStudents(theStudents);

            // query students where emeil LIKE %icloud.com

            theStudents = session
                    .createQuery("from Student s where s.email LIKE '%icloud.com'").getResultList();
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent: theStudents) {
            System.out.println(tempStudent);
        }
    }
}
