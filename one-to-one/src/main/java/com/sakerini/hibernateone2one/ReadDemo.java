package com.sakerini.hibernateone2one;

import com.sakerini.hibernateone2one.entity.Instructor;
import com.sakerini.hibernateone2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            Instructor tempInstructor = tempInstructorDetail.getInstructor();

            System.out.println();
            System.out.println(tempInstructor.toString());
            System.out.println();
            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
