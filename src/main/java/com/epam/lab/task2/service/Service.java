package com.epam.lab.task2.service;

import com.epam.lab.task2.dao.DAOClass;
import com.epam.lab.task2.model.Student;
import com.epam.lab.task2.model.Subject;
import com.epam.lab.task2.transformer.StudentTransformer;
import com.epam.lab.task2.transformer.SubjectTransformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private DAOClass daoClass;
    private Connection connection;
    private PreparedStatement statement;

    public Service() {
        daoClass = new DAOClass();
        connection = daoClass.getConnection();
    }

    public void insertSubject(Subject subject) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("subject");
        while (resultSet.next()){
            if(subject.getId()==resultSet.getInt(1)){
                System.out.println("Id " + subject.getId() + " already exists");
                return;
            }
        }
        daoClass.addRecordToDB(SubjectTransformer.transformToStatement(connection, subject));
    }

    public List<Subject> getSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        ResultSet resultSet = daoClass.getAllRecordsFromTable("subject");
        while (resultSet.next()) {
            subjects.add(SubjectTransformer.transformToSubject(resultSet));
        }
        return subjects;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        ResultSet resultSet = daoClass.getAllRecordsFromTable("student");
        while (resultSet.next()) {
            students.add(StudentTransformer.transformToStudent(resultSet, daoClass));
        }
        return students;
    }

    public void insertStudent(Student student) throws SQLException {
        ResultSet resultSet = daoClass.getAllRecordsFromTable("student");
        while (resultSet.next()){
            if(student.getId()==resultSet.getInt(1)){
                System.out.println("Id " + student.getId() + " already exists");
                return;
            }
        }
        daoClass.addRecordToDB(StudentTransformer.transformToStatement(connection, student));
    }

    public void deleteStudent() throws SQLException {
        daoClass.deleteStudent(9);
    }

    public void updateStudentLastName(int id, String newLastName) throws SQLException {
        daoClass.updateLastName(id, newLastName);
    }

    public void deleteGroup(int groupId, int newGroupId) throws SQLException {
        daoClass.updateStudentGroup(groupId, newGroupId);
        daoClass.deleteGroup(groupId);
    }
}