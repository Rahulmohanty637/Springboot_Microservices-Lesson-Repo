package org.MTM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LaptopMTM lap1   = new LaptopMTM();
        lap1.setLid(1);
        lap1.setRam(16);
        lap1.setBrand("Asus");
        lap1.setModel("Rog");

        LaptopMTM lap2 = new LaptopMTM();
        lap2.setLid(2);
        lap2.setRam(18);
        lap2.setBrand("Dell");
        lap2.setModel("Omega");

        LaptopMTM lap3 = new LaptopMTM();
        lap3.setLid(3);
        lap3.setRam(32);
        lap3.setBrand("HP");
        lap3.setModel("Omen");

        LaptopMTM lap4 = new LaptopMTM();
        lap4.setLid(4);
        lap4.setRam(64);
        lap4.setBrand("Apple");
        lap4.setModel("macbook");

        AlienMTM a1 = new AlienMTM();
        a1.setAid(101);
        a1.setAname("Rahul");
        a1.setTech("Java");

        AlienMTM a2 = new AlienMTM();
        a2.setAid(102);
        a2.setAname("Harsh");
        a2.setTech("Python");

        AlienMTM a3 = new AlienMTM();
        a3.setAid(103);
        a3.setAname("Piyush");
        a3.setTech("C++");

        a1.setLaptops(Arrays.asList(lap1, lap2, lap3));
        a2.setLaptops(Arrays.asList(lap2, lap3));
        a3.setLaptops(Arrays.asList(lap4));

        lap1.setAliens(Arrays.asList(a1));
        lap2.setAliens(Arrays.asList(a1, a2));
        lap3.setAliens(Arrays.asList(a1, a2));
        lap4.setAliens(Arrays.asList(a3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.MTM.AlienMTM.class)
                .addAnnotatedClass(org.MTM.LaptopMTM.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(lap1);
        session.persist(lap2);
        session.persist(lap3);
        session.persist(lap4);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        transaction.commit();

        AlienMTM a4 = session.get(AlienMTM.class, 102);
        System.out.println(a4);
        session.close();
        sf.close();
    }
}
