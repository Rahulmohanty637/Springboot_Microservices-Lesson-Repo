package org.OTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setRam(16);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setRam(18);
        l2.setBrand("Dell");
        l2.setModel("Omega");

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setRam(32);
        l3.setBrand("HP");
        l3.setModel("Omen");

        Laptop l4 = new Laptop();
        l4.setLid(4);
        l4.setRam(64);
        l4.setBrand("Apple");
        l4.setModel("macbook");

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Rahul");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");

        a1.setLaptops(Arrays.asList(l1, l2, l3, l4));
        a2.setLaptops(Arrays.asList(l3, l4));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.OTM.Alien.class)
                .addAnnotatedClass(org.OTM.Laptop.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(l4);
        session.persist(a1);
        transaction.commit();

        Session session1 = sf.openSession();
        Alien a3 = session1.get(Alien.class, 101);
//        System.out.println(a3);
        session.close();
        session1.close();
        sf.close();
    }
}