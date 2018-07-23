package com.epam.lab.task2.model;

import com.epam.lab.task5.annotations.ColumnName;
import com.epam.lab.task5.annotations.TableName;

@TableName(tableName = "address")
public class Address {

    @ColumnName(columnName = "address_id")
    private int id;
    @ColumnName(columnName = "country")
    private String country;
    @ColumnName(columnName = "region")
    private String region;
    @ColumnName(columnName = "city")
    private String city;
    @ColumnName(columnName = "street")
    private String street;
    @ColumnName(columnName = "house")
    private String house;
    @ColumnName(columnName = "apartment")
    private int apartment;

    public Address(int id, String country, String region, String city, String street, String house, int apartment) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public Address() {

    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }
}