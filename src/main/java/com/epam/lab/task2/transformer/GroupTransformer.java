package com.epam.lab.task2.transformer;

import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.Group;
import com.epam.lab.task2.model.Speciality;

import java.sql.*;
import java.util.Objects;

public class GroupTransformer {

    public static Group transformToGroup(ResultSet resultSet, DAOClass daoClass) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Group(
                    resultSet.getInt("group_id"),
                    resultSet.getString("group_name"),
                    resultSet.getInt("course"),
                    getSpeciality(resultSet.getInt("speciality_id"), daoClass));
        }
        return new Group();
    }

    private static Speciality getSpeciality(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("speciality");
        while (resultSet.next()) {
            if (resultSet.getInt("speciality_id") == id)
                return SpecialityTransformer.transformToSpeciality(resultSet);
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