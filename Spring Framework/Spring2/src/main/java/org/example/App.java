package org.example;

import org.example.config.AppConfig;
import org.example.config.ComponentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);

        Alien obj1 = context.getBean(Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();

//        Desktop dt1 = context.getBean("desktop",Desktop.class);
//        dt1.compile();
//
//        Desktop dt2 = context.getBean("desktop",Desktop.class);
//        dt2.compile();
    }
}
