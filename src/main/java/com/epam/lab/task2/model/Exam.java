package com.epam.lab.task2.model;

public class Exam {

    private Subject subject;
    private Student student;
    private String date;
    private int rating;

    public Exam(Subject subject, Student student, String date, int rating) {
        this.subject = subject;
        this.student = student;
        this.date = date;
        this.rating = rating;
    }

    public Exam() {

    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Subject getSubject() {
        return subject;
    }

    public Student getStudent() {
        return student;
    }

    public String getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }
}