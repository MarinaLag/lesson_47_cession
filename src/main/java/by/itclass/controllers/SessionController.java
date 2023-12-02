package by.itclass.controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sessionController", urlPatterns = "/handler")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // setAttribute - записать
        session.setAttribute("sessionMassage", "I am session attribute");
        req.setAttribute("requestMassage", "I am request attribute");

        // перенаправляем запрос туда, где мы ходим его видеть
        req.getRequestDispatcher("/message").forward(req, resp);
    }

    // http://localhost:8080/handler
}
