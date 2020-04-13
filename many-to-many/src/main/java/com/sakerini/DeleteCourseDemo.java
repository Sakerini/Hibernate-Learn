package com.sakerini;

import com.sakerini.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int courseId = 12;
            Course course = session.get(Course.class, courseId);

            session.delete(course);

            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
