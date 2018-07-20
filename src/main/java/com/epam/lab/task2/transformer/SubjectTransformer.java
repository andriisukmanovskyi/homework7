package com.epam.lab.task2.transformer;

import com.epam.lab.task2.model.Subject;

import java.sql.*;
import java.util.Objects;

public class SubjectTransformer {

    public static Subject transformToSubject(ResultSet resultSet) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Subject(resultSet.getInt("subject_id"),
                    resultSet.getString("subject_name"),
                    resultSet.getString("subject_description"));
        }
        return new Subject();
    }

    public static PreparedStatement transformToStatement(Connection connection, Subject subject) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subject(subject_id, subject_name, subject_description) VALUES (?,?,?);");
        preparedStatement.setInt(1, subject.getId());
        preparedStatement.setString(2, subject.getName());
        preparedStatement.setString(3, subject.getDescription());
        return preparedStatement;
    }
}