package com.epam.lab.task4;

import com.epam.lab.task2.dao.DAOClass;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DAOClass daoClass = new DAOClass();
        Service service = new Service(daoClass.getConnection());
        service.readMetadata();
        service.getTables();
    }
}