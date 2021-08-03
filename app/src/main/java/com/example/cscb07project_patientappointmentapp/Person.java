package com.example.cscb07project_patientappointmentapp;

import java.util.Locale;

public abstract class Person {
    protected enum Gender{
        MALE,
        FEMALE
    }

    String fullName;
    String username;
    Gender gender;

    public Person(String fullName, String username, String gender){
        this.fullName = fullName;
        this.username = username;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
