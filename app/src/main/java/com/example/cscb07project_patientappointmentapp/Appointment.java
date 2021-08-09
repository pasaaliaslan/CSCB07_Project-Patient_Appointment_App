package com.example.cscb07project_patientappointmentapp;


import com.google.firebase.Timestamp;

import java.util.List;
import java.util.Arrays;

public class Appointment{

    Doctor doctor;
    Patient patient;
    Timestamp startTime;
    String description;
    UID uid;

    public Appointment(Doctor doctor, Patient patient, Timestamp startTime, String description){
        this.doctor = doctor;
        this.startTime = startTime;
        this.patient = patient;
        this.description = description;
        this.uid = uid;
    }

    public String getDate(){
       String hold = this.startTime.toDate().toString();
       List<String> splits = Arrays.asList(hold.split("\\s+"));
       return(splits.get(0) + ", " + splits.get(1) + " " + splits.get(2) + ", " +splits.get(5));
    }

    public String getTime(){
        String hold = this.startTime.toDate().toString();
        List<String> splits = Arrays.asList(hold.split("\\s+"));
        return(splits.get(3));
    }
}


