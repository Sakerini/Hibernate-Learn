package com.sakerini;

import com.sakerini.entity.Course;
import com.sakerini.entity.Instructor;
import com.sakerini.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor tempInstructor =
                    new Instructor("Cristiano", "Ronaldo", "CR7@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http:/www.youtube.com/CR7", "football");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.save(tempInstructor);



            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
