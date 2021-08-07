package com.example.cscb07project_patientappointmentapp.Objects;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

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
}
