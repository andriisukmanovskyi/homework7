package com.epam.lab.task2;


import com.epam.lab.task2.model.Student;
import com.epam.lab.task2.service.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Service service = new Service();
//        service.insertStudent(ModelHelper.createStudent());
//        List<Subject> subjects = service.getSubjects();
//        subjects.forEach(s -> System.out.println(s.getId()));
        List<Student> students = service.getStudents();
        students.forEach(s -> System.out.println(s.getId() + " " + s.getFirstName() + " " + s.getLastName()));
//        service.updateStudentLastName(5, "\'XAXAXA\'");
//        service.deleteGroup(44, 1);
//        service.insertSubject(ModelHelper.createSubject());
    }
}