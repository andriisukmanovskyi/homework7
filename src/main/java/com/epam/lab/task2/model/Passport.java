package com.epam.lab.task2.model;

public class Passport {

    private int id;
    private String series;
    private int number;
    private String issueDate;
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