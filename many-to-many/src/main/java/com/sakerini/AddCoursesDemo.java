package com.sakerini;

import com.sakerini.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesDemo {
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
            int robertId = 2;
            Student student = session.get(Student.class, robertId);

            Course courseOne = new Course("Pure singing");
            Course courseTwo = new Course("Piano playing");
            Course courseThree = new Course("Mathematics & Informatics");

            student.addCourse(courseOne);
            student.addCourse(courseTwo);
            student.addCourse(courseThree);

            session.save(courseOne);
            session.save(courseTwo);
            session.save(courseThree);


            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
