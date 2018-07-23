package com.epam.lab.task2.transformer;

import com.epam.lab.task2.model.Passport;

import java.sql.*;
import java.util.Objects;

public class PassportTransformer {

    public static Passport transformToPassport(ResultSet resultSet) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Passport(
                    resultSet.getInt("passport_id"),
                    resultSet.getString("passport_series"),
                    resultSet.getInt("passport_number"),
                    resultSet.getString("issue_date"),
                    resultSet.getString("issue_organisation"));
        }
        return new Passport();
    }

    public static PreparedStatement transformToStatement(Connection connection, Passport passport) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO passport(passport_id, `passport_series`, `passport_number`, `issue_date`, `issue_organisation`) VALUES (?,?,?,?,?);");
        statement.setInt(1, passport.getId());
        statement.setString(2, passport.getSeries());
        statement.setInt(3, passport.getNumber());
        statement.setDate(4, Date.valueOf(passport.getIssueDate()));
        statement.setString(5, passport.getIssueOrganisation());
        return statement;
    }
}
