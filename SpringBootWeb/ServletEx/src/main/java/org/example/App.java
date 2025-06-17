package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080); // Optional: default is 8080
        tomcat.setBaseDir("temp");

        // Create context with current directory as docBase
        Context context = tomcat.addContext("", new File(".").getAbsolutePath());

        // Register the servlet
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
