package com.epam.lab.db.creation;

import com.mysql.cj.jdbc.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection;
        Driver driver = new Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/univer?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "root");
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false", "root", "root");
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
            scriptRunner.runScript(new BufferedReader(new FileReader("src/main/resources/univer_creation.sql")));
        }
        connection.close();
    }
}