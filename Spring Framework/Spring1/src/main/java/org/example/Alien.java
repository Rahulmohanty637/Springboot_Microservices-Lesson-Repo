package org.example;


public class Alien {

    private int age;
    private Computer com;

//    public Alien(int age, Laptop lap) {
//        this.age = age;
//        this.lap = lap;
//    }

    public Alien() {
//        System.out.println("Object Created!");
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void code() {
//        System.out.println("Coding");
        com.compile();
    }

}
