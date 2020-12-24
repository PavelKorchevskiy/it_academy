package org.example.controller;

import org.example.model.Student;
import org.example.repository.RepositoryForStudentsInMemory;
import org.example.repository.RepositoryForStudentsInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/rating")
public class ControllerForShowRating extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        RepositoryForStudentsInterface repository = RepositoryForStudentsInMemory.getInstance();
        Optional<Student> student = repository.findByLogin(login);
        String answer;
        if (student.isPresent()) {
            answer = student.get().getRatingAsString();
        } else {
            answer = "Пользаватель с таким логином не найден";
        }
        HttpSession session = req.getSession();
        session.setAttribute("answer", answer);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showRating");
        requestDispatcher.forward(req, resp);
    }
}
