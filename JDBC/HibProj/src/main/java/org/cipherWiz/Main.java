package org.cipherWiz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                setData(sc, sf);
                break;
            case 2:
                getData(sf);
                break;
            case 3:
                updateData(sc, sf);
                break;
            case 4:
                deleteData(sc, sf);
                break;
            default:
                System.out.println("choose between 1 to 4");
        }

        sf.close();
    }

    public static void setData(Scanner sc, SessionFactory sf) {
        Student st = new Student();

        System.out.println("Enter the roll no. :");
        int rn = sc.nextInt();

        System.out.println("Enter the age :");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Name :");
        String name = sc.nextLine();

        st.setRollNo(rn);
        st.setsAge(age);
        st.setsName(name);

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(st);

        transaction.commit();
        session.close();

        System.out.println(st);
    }

    public static void getData(SessionFactory sf) {
        Student st = null;

        Session session = sf.openSession();

        st = session.get(Student.class, 102);
        session.close();

        System.out.println(st);
    }

    public static void updateData(Scanner sc, SessionFactory sf) {
        Student st = new Student();

        System.out.println("Enter the roll no. :");
        int rn = sc.nextInt();

        System.out.println("Enter the age :");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the Name :");
        String name = sc.nextLine();

        st.setRollNo(rn);
        st.setsAge(age);
        st.setsName(name);

        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // it will update the data and if there is no record it will create a new record
        session.merge(st);
        transaction.commit();
        session.close();

        System.out.println(st);
    }

    public static void deleteData(Scanner sc, SessionFactory sf) {
        Student st = null;

        System.out.println("Enter the roll no. :");
        int id = sc.nextInt();

        Session session = sf.openSession();
        st = session.get(Student.class, id);

        Transaction transaction = session.beginTransaction();

        session.remove(st);
        transaction.commit();
        session.close();

        System.out.println("Deleted successfully!");
    }
}