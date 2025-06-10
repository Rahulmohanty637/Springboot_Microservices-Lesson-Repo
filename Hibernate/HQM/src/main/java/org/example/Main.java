package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // both methods are used for lazy loading but load() got deprecated, and get() is used for eager loading
        Laptop l1 = session.load(Laptop.class, 4);
        Laptop l2 = session.byId(Laptop.class).getReference(4);
        System.out.println(l1);
        System.out.println(l2);

        String brand = "Asus";

        Query query = session.createQuery("select model, brand from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Objects[]> laptopList = query.getResultList();

        System.out.println(laptopList);

        for (Object [] data : laptopList){
            System.out.println(data[0] + " " + data[1]);
        }

        level2Caching(sf);

        transaction.commit();
        session.close();
        sf.close();
    }

    public static void level2Caching (SessionFactory sf){
        Session session = sf.openSession();

        // Level one caching, implemented by default in hibernate when 2 same requests were made using same session
        Laptop l1 = session.get(Laptop.class, 2);
        Laptop l2 = session.get(Laptop.class, 2);
        System.out.println(l1);
        System.out.println(l2);
        session.close();

        // Level two caching
        Session session1 = sf.openSession();
        Laptop l3 = session1.get(Laptop.class, 1);
        System.out.println(l3);
        session1.close();

        Session session2 = sf.openSession();
        Laptop l4 = session2.get(Laptop.class, 1);
        System.out.println(l4);
        session2.close();

    }
}