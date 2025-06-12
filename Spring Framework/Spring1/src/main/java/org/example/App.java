package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        // This context will create the container as well as the objects of the classes mentioned as bean in xml configuration by default at the time of container loading. But the scope should be singleton
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        System.out.println("Hello World!");

        // If the scope of bean is prototype then the object will be created upon getBean() calling, because it will create a different object everytime getBean will be called, whereas bean with singleton scope will create only one object no matter how many times getBean() is called.
        Alien obj1 = context.getBean("alien", Alien.class);
//        obj1.setAge(21);
        System.out.println(obj1.getAge());
        obj1.code();

//        Alien obj2 = (Alien) context.getBean("alien");
//        obj2.age = 25;
//        System.out.println(obj2.age);

    }
}
