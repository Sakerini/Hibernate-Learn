package com.sakerini.hibernateone2one;

import com.sakerini.hibernateone2one.entity.Instructor;
import com.sakerini.hibernateone2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            // create objects

            Instructor tempInstructor =
                    new Instructor("George", "Rowan", "Rowang@gmail.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.rowan.com/youtube", "hockey");

            // link them together
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.save(tempInstructor);
            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }
    }
}
