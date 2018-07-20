package com.epam.lab.task2.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class DAOClass {

    Connection connection;

    public Connection getConnection() {
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/univer?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "root");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void addRecordToDB(PreparedStatement statement) throws SQLException {
        statement.execute();
    }

    public ResultSet getAllRecordsFromTable(String tableName) throws SQLException {
        return connection.createStatement().executeQuery("SELECT * FROM " + tableName + ";");
    }

    public void deleteStudent(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM student WHERE student_id=" + id);
    }

    public void updateLastName(int id, String last_name) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE student SET first_name = " + last_name + " WHERE student_id = " + id);
    }

    public void deleteGroup(int id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM groupp WHERE group_id = " + id);
    }

    public void updateStudentGroup(int groupId, int newGroupId) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE student SET group_id = " + newGroupId + " WHERE group_id = " + groupId);
    }

    public void addFewRecordsToDB(PreparedStatement statement) throws SQLException {
        try {
            connection.setAutoCommit(false);
            statement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}