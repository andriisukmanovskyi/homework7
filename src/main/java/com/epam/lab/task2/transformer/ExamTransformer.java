package com.epam.lab.task2.transformer;

import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.Exam;
import com.epam.lab.task2.model.Group;
import com.epam.lab.task2.model.Student;
import com.epam.lab.task2.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ExamTransformer {

    public static Exam transformToExam(ResultSet resultSet, DAOClass daoClass) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Exam(
                    getSubject(resultSet.getInt("subject_id"), daoClass),
                    getStudent(resultSet.getInt("student_id"), daoClass),
                    resultSet.getString("date"),
                    resultSet.getInt("rating"));
        }
        return new Exam();
    }

    private static Subject getSubject(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("subject");
        while (resultSet.next()) {
            if (resultSet.getInt("subject_id") == id)
                return SubjectTransformer.transformToSubject(resultSet);
        }
        return null;
    }

    private static Student getStudent(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("student");
        while (resultSet.next()) {
            if (resultSet.getInt("student_id_id") == id)
                return StudentTransformer.transformToStudent(resultSet, daoClass);
        }
        return null;
    }

    public static PreparedStatement transformToStatement(Connection connection, Group group) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO groupp(`group_id`, `group_name`, `speciality_id`, `course`) VALUES (?,?,?,?);");
        statement.setInt(1, group.getId());
        statement.setString(2, group.getName());
        statement.setInt(3, group.getSpeciality().getId());
        statement.setInt(4, group.getCourse());
        return statement;
    }
}
