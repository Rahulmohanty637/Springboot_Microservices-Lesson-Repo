package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setRam(16);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        Alien a1 = new Alien();
        a1.setAid(111);
        a1.setAname("Rahul");
        a1.setTech("Java");
        a1.setLaptop(l1);


//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.cipherWiz.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a1);
        transaction.commit();

        Alien a2 = session.get(Alien.class, 111);
        System.out.println(a2);
        session.close();
    }
}