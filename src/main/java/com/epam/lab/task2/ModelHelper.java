package com.epam.lab.task2;

import com.epam.lab.task2.model.*;

public class ModelHelper {

    public static Student createStudent() {
        return new Student(222, "Brown", "Jack", "James",
                "male", "1995-12-12",
                createAddress(), "2010-11-11", "380654585254", createPassport(),
                231458, chooseGroup(),
                "day", createParent());
    }

    public static Address createAddress() {
        return new Address(222, "USA", "DC", "Washington", "Street", "97a", 20);
    }

    public static Passport createPassport() {
        return new Passport(222, "HO", 124756, "2002-12-03", "organisation");
    }

    public static Group createGroup() {
        return new Group(44, "SE-82", 2, createSpeciality());
    }

    public static Speciality createSpeciality() {
        return new Speciality(34, "speciality", "spec description", null);
    }

    public static Parent createParent() {
        return new Parent(222, "fName", "lName", "secName", "548652315478");
    }

    public static Subject createSubject() {
        return new Subject(333, "subject", "sub description");
    }

    private static Group chooseGroup(){
        return new Group(44, "SE-82", 2, new Speciality(34, "speciality", "spec description", null));
    }
}
