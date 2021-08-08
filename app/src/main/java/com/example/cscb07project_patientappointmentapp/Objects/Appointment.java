package com.example.cscb07project_patientappointmentapp.Objects;


import com.google.firebase.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Arrays;
import com.example.cscb07project_patientappointmentapp.Objects.Doctor;
import com.example.cscb07project_patientappointmentapp.Objects.Patient;

public class Appointment{

    Doctor doctor;
    Patient patient;
    Timestamp startTime;
    String description;


    public Appointment(Doctor doctor, Patient patient, Timestamp startTime, String description){
        this.doctor = doctor;
        this.startTime = startTime;
        this.patient = patient;
        this.description = description;

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
