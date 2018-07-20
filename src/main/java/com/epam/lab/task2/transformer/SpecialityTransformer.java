package com.epam.lab.task2.transformer;

import com.epam.lab.task2.model.Speciality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SpecialityTransformer {

    public static Speciality transformToSpeciality(ResultSet resultSet) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Speciality(
                    resultSet.getInt("speciality_id"),
                    resultSet.getString("speciality_name"),
                    resultSet.getString("speciality_description"), null);
        }
        return new Speciality();
    }

    public static PreparedStatement transformToStatement(Connection connection, Speciality speciality) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO speciality(speciality_id, speciality_name, speciality_description) VALUES (?,?,?);");
        statement.setInt(1, speciality.getId());
        statement.setString(2, speciality.getName());
        statement.setString(3, speciality.getDescription());
        return statement;
    }
}