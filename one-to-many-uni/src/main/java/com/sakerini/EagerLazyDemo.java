package com.sakerini;

import com.sakerini.entity.Course;
import com.sakerini.entity.Instructor;
import com.sakerini.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EagerLazyDemo {
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

            int theId = 1;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                            + "join fetch i.courses "
                                            + "where i.id=:theInstructorId");

            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourses());
            session.getTransaction().commit();


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
