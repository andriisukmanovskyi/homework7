package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

import java.util.Objects;

@TableName(tableName = "groupp")
public class Group {

    @ColumnName(columnName = "group_id")
    private int id;
    @ColumnName(columnName = "group_name")
    private String name;
    @ColumnName(columnName = "course")
    private int course;
    @ColumnName(columnName = "speciality_id", foreignKey = true, foreignColumnIdName = "speciality_id")
    private Speciality speciality;

    public Group(int id, String name, int course, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.course = course;
        if (Objects.nonNull(speciality))
            this.speciality = speciality;
        else
            this.speciality = new Speciality();
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