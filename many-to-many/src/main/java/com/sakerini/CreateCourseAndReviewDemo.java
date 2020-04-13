package com.sakerini;

import com.sakerini.entity.Course;
import com.sakerini.entity.Instructor;
import com.sakerini.entity.InstructorDetail;
import com.sakerini.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;

            Course courseOne = new Course("Guitar");
            Course courseTwo = new Course("Singing");

            courseOne.addReview(new Review("Great Guitar playings"));
            courseOne.addReview(new Review("Best Guitar teacher"));
            courseTwo.addReview(new Review("Top Rock singer"));

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
