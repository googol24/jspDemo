package com.googol24.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletToJsp")
public class ServletToJsp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 设置属性并将它提交给ServletUseJsp.jsp
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setAttribute("servletName", "ServletToJsp");
            this.getServletConfig().getServletContext().getRequestDispatcher("/jsp_servlet/ServletUseJsp.jsp").forward(request, response);
        } catch (Exception e)  {
            e.printStackTrace();
        }
    }
}
