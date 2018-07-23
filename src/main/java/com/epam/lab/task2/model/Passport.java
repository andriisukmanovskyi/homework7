package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

@TableName(tableName = "passport")
public class Passport {

    @ColumnName(columnName = "passport_id")
    private int id;
    @ColumnName(columnName = "passport_series")
    private String series;
    @ColumnName(columnName = "passport_number")
    private int number;
    @ColumnName(columnName = "issue_date")
    private String issueDate;
    @ColumnName(columnName = "issue_organisation")
    private String issueOrganisation;

    public Passport(int id, String series, int number, String issueDate, String issueOrganisation) {
        this.id = id;
        this.series = series;
        this.number = number;
        this.issueDate = issueDate;
        this.issueOrganisation = issueOrganisation;
    }

    public Passport() {

    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setIssueOrganisation(String issueOrganisation) {
        this.issueOrganisation = issueOrganisation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getIssueOrganisation() {
        return issueOrganisation;
    }
}