package by.itclass.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "massageController", urlPatterns = "/message")
public class MassageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionMassage = (String) session.getAttribute("sessionMassage");
        String requestMassage = (String) req.getAttribute("requestMassage");
        resp.getWriter()
                .append("Session message: " + sessionMassage + "\n")
                .append("request message: " + requestMassage);
    }
    // сессия будет жить дольше
    // request пришел и ушел (можно указать  web.xml)
}
