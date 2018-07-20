package com.epam.lab.task4;


import java.sql.*;

public class Service {

    private Connection connection;
    private DatabaseMetaData databaseMetaData;

    public Service(Connection connection) throws SQLException {
        this.connection = connection;
        databaseMetaData = connection.getMetaData();
    }

    public void readMetadata() throws SQLException {
        if (databaseMetaData != null) {
            System.out.println("DB version: " + databaseMetaData.getDatabaseProductVersion());
            System.out.println("Driver name: " + databaseMetaData.getDriverName());
            System.out.println("Driver version: " + databaseMetaData.getDriverVersion());
            System.out.println("URL: " + databaseMetaData.getURL());
            System.out.println("User name: " + databaseMetaData.getUserName());
        }
    }

    public void getTables() throws SQLException {
        ResultSet resultSet = databaseMetaData.getTables(null, "univer", "%", new String[]{"TABLE"});
        while (resultSet.next()) {
            String tableName = resultSet.getString(3);
            System.out.println("\ntable: " + tableName);
            String columnNamePattern = null;
            ResultSet resultSetColumns = databaseMetaData.getColumns(null, null, tableName, columnNamePattern);
            ResultSet resultSetPK = databaseMetaData.getPrimaryKeys(null, null, tableName);
            while (resultSetColumns.next()) {
                String columnName = resultSetColumns.getString("COLUMN_NAME");
                String columnType = resultSetColumns.getString("TYPE_NAME");
                int columnSize = resultSetColumns.getInt("COLUMN_SIZE");
                System.out.println("\t" + columnName + " - " + columnType + "(" + columnSize + ")");
            }
            while (resultSetPK.next()) {
                String primaryKeyColumn = resultSetPK.getString("COLUMN_NAME");
                System.out.println("\tPrimary Key Column: " + primaryKeyColumn);
            }
        }
    }
}