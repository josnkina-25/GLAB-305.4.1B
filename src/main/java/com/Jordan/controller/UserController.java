package com.Jordan.controller;
import com.Jordan.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserController {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();

    public static void main(String[] args) {
        // Create Hibernate session and factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Uncomment the method you want to test

        // Add new users
//        addUser(factory, session);

        // Find a user by ID
//         findUser(factory, session, 1);

        // Update a user by ID
//         updateUser(session, 1);

        // Delete a user by ID
         deleteUser(session, 1);
    }




    public static void addUser(SessionFactory factory, Session session){
           Transaction transaction = session.beginTransaction();
           User uOne = new User();
           uOne.setEmail("haseeb@gmail.com");
           uOne.setFullName("Moh Haseed");
           uOne.setPassword("has123");
           uOne.setSalary(2000.69);
           uOne.setAge(20);
           uOne.setCity("NYC");

           User uTwo = new User();
           uTwo.setEmail("James@gmail.com");
           uTwo.setFullName("James Santana");
           uTwo.setPassword("James123");
           uTwo.setSalary(2060.69);
           uTwo.setAge(25);
           uTwo.setCity("Dallas");

           User uThree = new User();
           uThree.setEmail("Shahparan@gmail.com");
           uThree.setFullName("AH Shahparan");
           uThree.setPassword("Shahparan123");
           uThree.setSalary(3060.69);
           uThree.setAge(30);
           uThree.setCity("Chicago");

           User uFour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.3, "NJ");
           User uFive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA");
           // Integer userid = null;

           session.persist(uOne);
           session.persist(uTwo);
           session.persist(uThree);
           session.persist(uFour);
           session.persist(uFive);

           transaction.commit();
           System.out.println("successfully saved");
           factory.close();
           session.close();
       }
    public static void findUser(SessionFactory factory,Session session,int userId){
//

        Transaction tx = session.beginTransaction();

        User u = session.get(User.class, userId);
        System.out.println("FullName: " + u.getFullName());
        System.out.println("Email: " + u.getEmail());
        System.out.println("password: " + u.getPassword());

        //Close resources
        tx.commit();
        factory.close();
        session.close();
    }
    public static void updateUser(Session session, int userId) {


        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setId(userId);
        u.setEmail("mhaseeb@perscholas");
        u.setFullName("M Haseeb");
        u.setPassword("123456");
        session.merge(u);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteUser(Session session,int userId){

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setId(userId);
        session.remove(u);
        tx.commit();
        session.close();
        factory.close();
    }


}

