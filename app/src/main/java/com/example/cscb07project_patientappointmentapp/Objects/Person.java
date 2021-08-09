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
    Gender gender;
    ArrayList<Appointment> upcomingAppointments;
    ArrayList<Appointment> pastAppointments;

    public Person(String fullName, String username, String password, String gender){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.upcomingAppointments = new ArrayList<Appointment>();
        this.pastAppointments = new ArrayList<Appointment>();
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

    public String getGender() {
        return gender.toString().toUpperCase();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
