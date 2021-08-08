package com.example.cscb07project_patientappointmentapp.Objects;

import java.util.ArrayList;

public abstract class Person {
    protected enum Gender{
        MALE,
        FEMALE
    }

    String fullName;
    String username;
    String password;
    UID uid;
    Gender gender;
    ArrayList<UID> upcomingAppointments;
    ArrayList<UID> pastAppointments;

    public Person(String fullName, String username, String password, String gender, UID uid){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.upcomingAppointments = new ArrayList<UID>();
        this.pastAppointments = new ArrayList<UID>();
    }

    public UID getUID() { return uid; }

    public void setUID(UID uid) { this.uid = uid;}

    public ArrayList<UID> getAppointments() {
        return upcomingAppointments;
    }

    public void setAppointments(ArrayList<UID> appointments) { this.upcomingAppointments = appointments; }

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
