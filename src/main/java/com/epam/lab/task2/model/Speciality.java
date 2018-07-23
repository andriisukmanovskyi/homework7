package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.JunctionTable;
import com.epam.lab.task5.annotations.TableName;

import java.util.List;
import java.util.Set;

@TableName(tableName = "speciality")
public class Speciality {

    @ColumnName(columnName = "speciality_id")
    private int id;
    @ColumnName(columnName = "speciality_name")
    private String name;
    @ColumnName(columnName = "speciality_description")
    private String description;
    @JunctionTable(tableName = "speciality_subject", currentColumnIdName = "speciality_id",
            junctionTableConditionColumnName = "speciality_id",
            junctionTableForeignColumnIdName = "subject_id", foreignColumnIdName = "subject_id",
            foreignObjectsType = Subject.class)
    private List<Subject> subjects;

    public Speciality(int id, String name, String description, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subjects = subjects;
    }

    public Speciality() {

    }

    public void setSubjects(List<Subject> subjects) {
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

    public List<Subject> getSubjects() {
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