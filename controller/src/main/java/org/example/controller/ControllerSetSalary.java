package org.example.controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.constans.Parameters;
import org.example.model.Teacher;
import org.example.service.Checking;
import org.example.service.SaveService;
import org.example.service.Supplier;

@WebServlet("/setSalary")
public class ControllerSetSalary extends HttpServlet {

  //админ выдает учителю одну зарплату
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BigDecimal newSalary = Checking.getSalary(req.getParameter(Parameters.SALARY));
    int id = Checking.getId(req.getParameter(Parameters.ID_TEACHER));
    Teacher teacher = Supplier.getTeacherWithId(id);
    teacher.getSalary().add(newSalary);
    SaveService.saveTeacher(teacher);
    req.getRequestDispatcher("pages/AdminSetSalary.jsp").forward(req, resp);
  }
}
