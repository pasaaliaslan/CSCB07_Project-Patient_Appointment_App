package com.example.cscb07project_patientappointmentapp.Objects;

import com.google.firebase.Timestamp;

public class Appointment{

    Doctor doctor;
    Patient patient;
    Timestamp startTime;
    String description;
    String id;

    public Appointment(Doctor doctor, Patient patient, Timestamp startTime, String description, String id){
        this.doctor = doctor;
        this.startTime = startTime;
        this.patient = patient;
        this.description = description;
        this.id = id;
    }
}
