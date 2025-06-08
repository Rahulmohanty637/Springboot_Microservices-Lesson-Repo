package org.cipherWiz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setRollNo(101);
        s1.setsAge(23);
        s1.setsName("Hitesh");

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.cipherWiz.Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(s1);

        transaction.commit();

        System.out.println(s1);
    }
}