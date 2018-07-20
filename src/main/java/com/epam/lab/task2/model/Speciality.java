package com.epam.lab.task2.model;

import java.util.Set;

public class Speciality {

    private int id;
    private String name;
    private String description;
    private Set<Subject> subjects;

    public Speciality(int id, String name, String description, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subjects = subjects;
    }

    public Speciality() {

    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}