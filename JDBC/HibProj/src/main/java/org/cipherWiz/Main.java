package org.cipherWiz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setRollNo(105);
        s1.setsAge(23);
        s1.setsName("Mehul");

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.cipherWiz.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.cipherWiz.Student.class)
                .configure()
                .buildSessionFactory();      // cfg.buildSessionFactory();

        int num = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the command :");
        num = sc.nextInt();

        switch (num) {
            case 1:
                setData(s1, sf);
                break;
            case 2:
                getData(sf);
                break;
            default:
                System.out.println("choose between 1 or 2");
        }

        sf.close();
    }

    public static void setData(Student st, SessionFactory sf) {
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(st);

        transaction.commit();
        session.close();

        System.out.println(st);
    }

    public static void getData(SessionFactory sf) {
        Student st2 = null;

        Session session = sf.openSession();

        st2 = session.get(Student.class, 102);
        session.close();

        System.out.println(st2);
    }
}