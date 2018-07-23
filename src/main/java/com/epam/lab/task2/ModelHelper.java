package com.epam.lab.task2;

import com.epam.lab.task2.model.*;

import java.sql.Date;
import java.util.ArrayList;

public class ModelHelper {

    public static Student createStudent() {
        return new Student(12344, "JJJ", "BBBB", "RRRRs",
                "male", Date.valueOf("1995-12-12"),
                createAddress(), Date.valueOf("2010-11-11"), "380654585254", createPassport(),
                231458, chooseGroup(),
                "day", createParent());
    }

    public static Address createAddress() {
        return new Address(1, "USA", "DC", "Washington", "Street", "97a", 20);
    }

    public static Passport createPassport() {
        return new Passport(1, "HO", 124756, "2002-12-03", "organisation");
    }

    public static Group createGroup() {
        return new Group(234, "SE-82", 2, createSpeciality());
    }

    public static Speciality createSpeciality() {
        return new Speciality(323348, "speciality", "spec description", new ArrayList<>());
    }

    public static Parent createParent() {
        return new Parent(1, "fName", "lName", "secName", "548652315478");
    }

    public static Subject createSubject() {
        return new Subject(3133, "subject", "sub description");
    }

    private static Group chooseGroup(){
        return new Group(234, "SE-82", 2, new Speciality(348, "speciality", "spec description", null));
    }
}
