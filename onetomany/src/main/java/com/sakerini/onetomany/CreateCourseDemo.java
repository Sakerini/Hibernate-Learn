package com.sakerini.onetomany;

import com.sakerini.onetomany.entity.Course;
import com.sakerini.onetomany.entity.Instructor;
import com.sakerini.onetomany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
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
            Instructor tempInstructor = session.get(Instructor.class, theId);

            Course courseOne = new Course("Guitar");
            Course courseTwo = new Course("Singing");

            tempInstructor.add(courseOne);
            tempInstructor.add(courseTwo);

            session.save(courseOne);
            session.save(courseTwo);

            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
