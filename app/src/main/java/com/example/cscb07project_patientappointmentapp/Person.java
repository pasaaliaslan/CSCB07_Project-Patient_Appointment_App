package com.example.cscb07project_patientappointmentapp;

import java.util.Locale;

public abstract class Person {
    protected enum Gender{
        MALE,
        FEMALE
    }

    String fullName;
    String username;
    String password;
    Gender gender;

    public Person(String fullName, String username, String password, String gender){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}