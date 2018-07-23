package com.epam.lab.task5;

import com.epam.lab.task2.ModelHelper;
import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.*;
import com.epam.lab.task5.universal.transformer.Transformer;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SQLException, IllegalAccessException, InvocationTargetException, InstantiationException {
        DAOClass daoClass = new DAOClass();
        Connection connection = daoClass.getConnection();

        Speciality speciality = ModelHelper.createSpeciality();
        speciality.getSubjects().add(new Subject(441, "f42f", "h65h5"));
        speciality.getSubjects().add(new Subject(442, "f42f", "h65h5"));
        speciality.getSubjects().add(new Subject(443, "f42f", "h65h5"));
        speciality.getSubjects().add(new Subject(444, "f42f", "h65h5"));
        Transformer<Speciality> transformer = new Transformer<>(speciality);
        PreparedStatement statement = transformer.getStatement(connection);
        daoClass.addRecordToDB(statement);
        for (Subject subject : speciality.getSubjects()) {
            daoClass.addRecordToDB(transformer.getJunctionTableStatement(connection, subject.getId()));
        }


//        Transformer<Speciality> transformer = new Transformer<>(new Speciality());
//        ResultSet resultSet = daoClass.getRecordById("speciality", 1, "speciality_id");
//        resultSet.next();
//        Speciality group = transformer.getObject(connection, resultSet);
//        System.out.println(" " + group.getId());
//        for (Subject subject : group.getSubjects()) {
//            System.out.println(subject.getId() + " " + subject.getDescription());
//        }
    }
}
