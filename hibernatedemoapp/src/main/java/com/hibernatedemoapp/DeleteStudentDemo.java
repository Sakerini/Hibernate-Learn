package com.hibernatedemoapp;

import com.hibernatedemoapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            int studentId = 3;
            session.beginTransaction();
            Student studentTemp = session.get(Student.class, studentId);

            session.delete(studentTemp);

            // deleting thorugh quiery id 2
            session.createQuery("Delete from Student where id=2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");


        }finally {
            sessionFactory.close();
        }
    }
}
