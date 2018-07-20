package com.epam.lab.task2.model;

public class Group {

    private int id;
    private String name;
    private int course;
    private Speciality speciality;

    public Group(int id, String name, int course, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.speciality = speciality;
    }

    public Group() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public Speciality getSpeciality() {
        return speciality;
    }
}