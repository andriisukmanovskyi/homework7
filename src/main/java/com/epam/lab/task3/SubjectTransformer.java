package com.epam.lab.task3;

import com.epam.lab.task2.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SubjectTransformer {

    public static PreparedStatement transformToStatementTransaction(Connection connection, List<Subject> subjects) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subject(subject_id, subject_name, subject_description) VALUES (?,?,?);");
        for (Subject subject : subjects) {
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.setString(3, subject.getDescription());
            preparedStatement.addBatch();
        }
        return preparedStatement;
    }
}