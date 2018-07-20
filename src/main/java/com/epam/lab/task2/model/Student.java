package com.epam.lab.task2.model;


public class Student extends Parent {

    private String sex;
    private String birthdayDate;
    private Address address;
    private String enterDate;
    private Passport passport;
    private int gradeBookNumber;
    private Group group;
    private String studyingForm;
    private Parent parent;

    public Student(int id, String lastName, String firstName, String secondName,
                   String sex, String birthdayDate, Address address, String enterDate,
                   String phoneNumber, Passport passport,
                   int gradeBookNumber, Group group, String studyingForm,
                   Parent parent) {
        super(id, firstName, lastName, secondName, phoneNumber);
        this.sex = sex;
        this.birthdayDate = birthdayDate;
        this.address = address;
        this.enterDate = enterDate;
        this.passport = passport;
        this.gradeBookNumber = gradeBookNumber;
        this.group = group;
        this.studyingForm = studyingForm;
        this.parent = parent;
    }

    public Student() {
        super();
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setStudyingForm(String studyingForm) {
        this.studyingForm = studyingForm;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public Passport getPassport() {
        return passport;
    }

    public int getGradeBookNumber() {
        return gradeBookNumber;
    }

    public Group getGroup() {
        return group;
    }

    public String getStudyingForm() {
        return studyingForm;
    }

    public Parent getParent() {
        return parent;
    }
}