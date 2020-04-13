package com.sakerini;

import com.sakerini.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {
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

            Course course = new Course("Luv2Code: Spring & Hibernate 4 begginers");

            session.save(course);

            Student studentOne = new Student("John", "Doe", "luv2code@gmail.com");
            Student studentTwo = new Student("Robert", "Rifario", "Rifario@gmail.com");

            course.addStudent(studentOne);
            course.addStudent(studentTwo);

            session.save(studentOne);
            session.save(studentTwo);

            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            sessionFactory.close();
            session.close();
        }
    }
}
