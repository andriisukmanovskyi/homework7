package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

@TableName(tableName = "parent")
public class Parent {

    @ColumnName(columnName = "parent_id")
    private int id;
    @ColumnName(columnName = "first_name")
    private String firstName;
    @ColumnName(columnName = "last_name")
    private String lastName;
    @ColumnName(columnName = "second_name")
    private String secondName;
    @ColumnName(columnName = "phone_number")
    private String phoneNumber;

    public Parent(int id, String firstName, String lastName, String secondName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public Parent() {

    }

    public Parent(String firstName, String lastName, String secondName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}