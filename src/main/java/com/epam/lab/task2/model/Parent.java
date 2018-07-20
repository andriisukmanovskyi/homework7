package com.epam.lab.task2.model;

public class Parent {

    private int id;
    private String firstName;
    private String lastName;
    private String secondName;
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