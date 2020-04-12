package com.sakerini.hibernateone2one;

import com.sakerini.hibernateone2one.entity.Instructor;
import com.sakerini.hibernateone2one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            /*
            // get the instructor by the pk

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class , theId);

            System.out.println("Found instructor: " + tempInstructor.toString());

            if (tempInstructor != null) {
                System.out.println("Delete insturctor...");

                // Node: this will also delete the cascaded object
                session.delete(tempInstructor);
            }
            // delete that instructor
            session.getTransaction().commit();

             */

            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

            if (tempInstructorDetail != null) {
                System.out.println("deleting...");
                // !!! BREAK THE ASSOCIATION !!!
                tempInstructorDetail.getInstructor().setInstructorDetail(null);

                session.delete(tempInstructorDetail);
            }
            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }
    }
}
