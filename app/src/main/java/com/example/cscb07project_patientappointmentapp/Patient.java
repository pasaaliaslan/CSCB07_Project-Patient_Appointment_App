package com.example.cscb07project_patientappointmentapp;

public class Patient {
    long id;
    String name;

    public Patient(long id, String name){
        this.id = id;
        this.name = name;
    }

    //HI

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
