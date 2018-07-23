package com.epam.lab.task2.transformer;

import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.*;

import java.sql.*;
import java.util.Objects;

public class StudentTransformer {

    public static Student transformToStudent(ResultSet resultSet, DAOClass daoClass) throws SQLException {
        if (Objects.nonNull(resultSet)) {
            return new Student(resultSet.getInt("student_id"),
                    resultSet.getString("last_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("sex"),
                    resultSet.getDate("birthday_date"),
                    getAddress(resultSet.getInt("address_id"), daoClass),
                    resultSet.getDate("enter_date"),
                    resultSet.getString("phone_number"),
                    getPassport(resultSet.getInt("passport_id"), daoClass),
                    resultSet.getInt("gradebook_no"),
                    getGroup(resultSet.getInt("group_id"), daoClass),
                    resultSet.getString("studying_form"),
                    getParent(resultSet.getInt("parent_id"), daoClass)
            );
        }
        return new Student();
    }

    private static Address getAddress(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("address");
        while (resultSet.next()) {
            if (resultSet.getInt("address_id") == id)
                return AddressTransformer.transformToAddress(resultSet);
        }
        return null;
    }

    private static Passport getPassport(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("passport");
        while (resultSet.next()) {
            if (resultSet.getInt("passport_id") == id)
                return PassportTransformer.transformToPassport(resultSet);
        }
        return null;
    }

    private static Group getGroup(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("groupp");
        while (resultSet.next()) {
            if (resultSet.getInt("group_id") == id)
                return GroupTransformer.transformToGroup(resultSet, daoClass);
        }
        return null;
    }

    private static Parent getParent(int id, DAOClass daoClass) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("parent");
        while (resultSet.next()) {
            if (resultSet.getInt("parent_id") == id)
                return ParentTransformer.transformToParent(resultSet);
        }
        return null;
    }

    public static PreparedStatement transformToStatement(Connection connection, Student student) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO student(student_id, `last_name`, `first_name`, " +
                        "`second_name`, `sex`, `birthday_date`, `address_id`, " +
                        "`enter_date`, `phone_number`, `passport_id`, `gradebook_no`, " +
                        "`group_id`, `studying_form`, `parent_id`) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        statement.setInt(1, student.getId());
        statement.setString(2, student.getLastName());
        statement.setString(3, student.getFirstName());
        statement.setString(4, student.getSecondName());
        statement.setString(5, student.getSex());
        statement.setDate(6, student.getBirthdayDate());
        statement.setInt(7, student.getAddress().getId());
        statement.setDate(8, student.getEnterDate());
        statement.setString(9, student.getPhoneNumber());
        statement.setInt(10, student.getPassport().getId());
        statement.setInt(11, student.getGradeBookNumber());
        statement.setInt(12, student.getGroup().getId());
        statement.setString(13, student.getStudyingForm());
        statement.setInt(14, student.getParent().getId());
        return statement;
    }
}