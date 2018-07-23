package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

import java.sql.Date;

@TableName(tableName = "student")
public class Student {

    @ColumnName(columnName = "student_id")
    private int id;
    @ColumnName(columnName = "first_name")
    private String firstName;
    @ColumnName(columnName = "last_name")
    private String lastName;
    @ColumnName(columnName = "second_name")
    private String secondName;
    @ColumnName(columnName = "phone_number")
    private String phoneNumber;
    @ColumnName(columnName = "sex")
    private String sex;
    @ColumnName(columnName = "birthday_date")
    private Date birthdayDate;
    @ColumnName(columnName = "address_id", foreignKey = true, foreignColumnIdName = "address_id")
    private Address address;
    @ColumnName(columnName = "enter_date")
    private Date enterDate;
    @ColumnName(columnName = "passport_id", foreignKey = true, foreignColumnIdName = "passport_id")
    private Passport passport;
    @ColumnName(columnName = "gradebook_no")
    private int gradeBookNumber;
    @ColumnName(columnName = "group_id", foreignKey = true, foreignColumnIdName = "group_id")
    private Group group;
    @ColumnName(columnName = "studying_form")
    private String studyingForm;
    @ColumnName(columnName = "parent_id", foreignKey = true, foreignColumnIdName = "parent_id")
    private Parent parent;

    public Student(int id, String lastName, String firstName, String secondName,
                   String sex, Date birthdayDate, Address address, Date enterDate,
                   String phoneNumber, Passport passport,
                   int gradeBookNumber, Group group, String studyingForm,
                   Parent parent) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
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

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEnterDate(Date enterDate) {
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

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public Address getAddress() {
        return address;
    }

    public Date getEnterDate() {
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