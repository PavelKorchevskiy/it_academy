package org.example.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.model.Teacher;
import org.example.repository.RepositoryForTeachersInMemory;
import org.example.repository.RepositoryForTeachersInterface;

public class AverageSalary {

  //calculating average salary for one teacher
  //берем зарплаты за последние numberOfMonths месяцев
  public static BigDecimal calculateAverageSalary(Teacher teacher, int numberOfMonths) {
    List<BigDecimal> salaries = new ArrayList<>(teacher.getSalary());
    Collections.reverse(salaries);
    BigDecimal sum = BigDecimal.ZERO;
    for (int i = 0; i < numberOfMonths; i++) {
      sum = sum.add(salaries.get(i));
    }
    return sum.divide(BigDecimal.valueOf(numberOfMonths), 2, RoundingMode.HALF_UP);
  }

  //calculating average salary for list of teachers
  public static BigDecimal calculateAverageSalary(List<Teacher> teachers, int numberOfMonths) {
    BigDecimal sum = BigDecimal.ZERO;
    for (Teacher teacher : teachers) {
      sum = sum.add(calculateAverageSalary(teacher, numberOfMonths));
    }
    return sum.divide(BigDecimal.valueOf(teachers.size()), 2, RoundingMode.HALF_UP);
  }

  public static String showAllTeachers() {
    RepositoryForTeachersInterface repository = RepositoryForTeachersInMemory.getInstance();
    List<Teacher> teachers = repository.findAll();
    StringBuilder sb = new StringBuilder();
    for (Teacher teacher : teachers) {
      sb.append(TeacherService.showSalary(teacher));
    }
    return sb.toString();
  }

  public static String showAverageSalaryForAllTeacher(int numberOfMonths) {
    RepositoryForTeachersInterface repository = RepositoryForTeachersInMemory.getInstance();
    List<Teacher> teachers = repository.findAll();
    BigDecimal averageSalary = calculateAverageSalary(teachers, numberOfMonths);
    String head = "Average salary for " + teachers.size() + " teachers, for " + numberOfMonths
        + " months - " + averageSalary.setScale(2, RoundingMode.HALF_UP) + "<br/>";
    StringBuilder sb = new StringBuilder();
    for (Teacher teacher : teachers) {
      sb.append("Average salary for ").append(teacher.getFullName()).append(" - ")
          .append(calculateAverageSalary(teacher, numberOfMonths)
              .setScale(2, RoundingMode.HALF_UP)).append("<br/>");
    }
    return head + sb.toString();
  }
}
