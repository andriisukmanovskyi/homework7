package com.epam.lab.task2.transformer;

import com.epam.lab.task2.model.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ParentTransformer {

    public static Parent transformToParent(ResultSet resultSet) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Parent(
                    resultSet.getInt("parent_id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("phone_number"));
        }
        return new Parent();
    }

    public static PreparedStatement transformToStatement(Connection connection, Parent parent) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO parent(parent_id, `last_name`, `first_name`, `second_name`, `phone_number`) VALUES (?,?,?,?,?);");
        statement.setInt(1, parent.getId());
        statement.setString(2, parent.getLastName());
        statement.setString(3, parent.getFirstName());
        statement.setString(4, parent.getSecondName());
        statement.setString(5, parent.getPhoneNumber());
        return statement;
    }
}