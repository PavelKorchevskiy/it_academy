package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

public class TeacherService {
    public static String showGroup(Teacher teacher) {
        Set<Student> group = teacher.getGroup();
        String head = teacher.getFullName() + ", in your group " + teacher.getGroup().size() + " students:</br>";
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : group) {
            stringBuilder.append(" name - ").append(student.getRatingAsString()).append(", id - ")
                    .append(student.getId()).append(";</br>");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return head + stringBuilder.toString();
    }

    public static String showSalary(Teacher teacher) {
        StringBuilder sb = new StringBuilder();
        sb.append("Teacher - ").append(teacher.getFullName()).append(", with id - ")
                .append(teacher.getId()).append(".<br/> His salary: ");
        for (BigDecimal b : teacher.getSalary()) {
            sb.append(b.setScale(2, RoundingMode.HALF_UP)).append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("<br/>");
        return sb.toString();
    }
}
