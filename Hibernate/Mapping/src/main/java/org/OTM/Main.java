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
        l1.setLid(3);
        l1.setRam(32);
        l1.setBrand("HP");
        l1.setModel("Omen");

        Laptop l4 = new Laptop();
        l1.setLid(4);
        l1.setRam(64);
        l1.setBrand("Apple");
        l1.setModel("macbook");

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Rahul");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1, l2, l3, l4));

        l1.setAlien(a1);
        l2.setAlien(a1);


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

        Alien a2 = session.get(Alien.class, 101);
        System.out.println(a2);
        session.close();
        sf.close();
    }
}