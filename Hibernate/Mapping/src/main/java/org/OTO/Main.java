package org.OTO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        LaptopOTO l1 = new LaptopOTO();
        l1.setLid(1);
        l1.setRam(16);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        AlienOTO a1 = new AlienOTO();
        a1.setAid(101);
        a1.setAname("Rahul");
        a1.setTech("Java");
        a1.setLaptop(l1);



        SessionFactory sf = new Configuration()
                .addAnnotatedClass(AlienOTO.class)
                .addAnnotatedClass(LaptopOTO.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(a1);
        transaction.commit();

        AlienOTO a2 = session.get(AlienOTO.class, 101);
        System.out.println(a2);
        session.close();
        sf.close();
    }
}
