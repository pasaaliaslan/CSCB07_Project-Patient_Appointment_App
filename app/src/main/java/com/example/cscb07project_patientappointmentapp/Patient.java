package com.example.cscb07project_patientappointmentapp;

public class Patient extends Person{

    String birthDate;

    public Patient(String fullName, String username, String password, String gender, String birthday) {
        super(fullName, username, password, gender);
        this.birthDate = birthday;
    }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
}
