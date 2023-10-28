package com.himm.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            session.setAttribute("username", "himmelbleu");
        }
        if (session.getAttribute("password") == null) {
            session.setAttribute("password", "123456");
        }
        System.out.println(session.getAttribute("username"));
        System.out.println(session.getAttribute("password"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
