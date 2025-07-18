package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In Service");
        res.setContentType("text/plain");
        res.getWriter().write("Hello from Servlet!");
    }
}
