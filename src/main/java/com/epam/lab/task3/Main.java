package com.epam.lab.task3;

import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.Subject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(3312, "subject", "sub description"));
        subjects.add(new Subject(4443, "subject", "sub description"));
        subjects.add(new Subject(323, "subject", "sub description"));
        subjects.add(new Subject(3785, "subject", "sub description"));
        DAOClass daoClass = new DAOClass();
        Connection connection = daoClass.getConnection();
        daoClass.addFewRecordsToDB(SubjectTransformer.transformToStatementTransaction(connection, subjects));
    }
}