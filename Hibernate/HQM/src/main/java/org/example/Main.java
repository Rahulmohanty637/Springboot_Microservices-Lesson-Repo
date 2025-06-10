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

        Laptop l1 = session.load(Laptop.class, 4);
        System.out.println(l1);

        String brand = "Asus";

        Query query = session.createQuery("select model, brand from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Objects[]> laptopList = query.getResultList();

        System.out.println(laptopList);

        for (Object [] data : laptopList){
            System.out.println(data[0] + " " + data[1]);
        }

        transaction.commit();
        session.close();
        sf.close();
    }
}