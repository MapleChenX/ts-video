package com.himm.servlets;

import com.himm.utils.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            boolean isFoundToken = false;
            for (Cookie cookie : cookies) {
                // 检查特定的 Cookie 名称
                if ("token".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    String username = JwtUtil.getUsername(value);
                    System.out.println("已经登陆：" + username);
                    isFoundToken = true;
                    break;
                }
            }

            if (!isFoundToken) {
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }
        }

    }
}
