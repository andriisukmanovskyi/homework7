package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

@TableName(tableName = "subject")
public class Subject {

    @ColumnName(columnName = "subject_id")
    private int id;
    @ColumnName(columnName = "subject_name")
    private String name;
    @ColumnName(columnName = "subject_description")
    private String description;

    public Subject(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Subject() {

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