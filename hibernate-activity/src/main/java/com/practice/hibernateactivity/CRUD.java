package com.practice.hibernateactivity;

import com.practice.hibernateactivity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUD {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Employee.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            /* // Create
            session.beginTransaction();
            Employee employe1 = new Employee("Alberto", "Torres", "DanceMINGO");
            Employee employe2 = new Employee("Ilon", "Mask", "Tesla");
            Employee employe3 = new Employee("Alex", "Chaushev", "Yandex");

            session.save(employe1);
            session.save(employe2);
            session.save(employe3);

            session.getTransaction().commit();
             */

            /*
            // Read
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            session.getTransaction().commit();
            */

            /*
            // Update
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            employee.setFirstName("Alfredo");

            session.createQuery("update Employee set company='NoEtic'").executeUpdate();

            session.getTransaction().commit();
             */

            /*
            // Delete
            session.beginTransaction();
            session.createQuery("delete Employee where id=2").executeUpdate();
            session.getTransaction().commit();
             */

        } finally {
            sessionFactory.close();
        }
    }
}
