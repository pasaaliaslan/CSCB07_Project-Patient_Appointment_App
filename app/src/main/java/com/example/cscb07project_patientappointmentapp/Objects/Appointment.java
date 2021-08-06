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

public class Appointment implements Comparable{

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

    @Override
    public int compareTo(Object o) {
        Appointment a = (Appointment) o;
        return this.startTime.compareTo(a.startTime);
    }


}

//public class Appointment {
//
//    Doctor doctor;
//    String appointmentDate;
//    boolean booked;
//    String description;
//    Patient patient;
//    int startTime;
//    int endTime;
//
//
//    public Appointment(Doctor doctor, int startTime) {
//        // for of appointmentDate must be yyyy-MM-dd
//        this.doctor = doctor;
//        this.appointmentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//        this.booked = false;
//        // shift are only 9 to 5, try using time object and not ints
//        if (startTime >= 0 && startTime <= 23) {
//            this.startTime = startTime;
//        } else {
//            throw new IllegalArgumentException("Please give a start time between 0 to 23.");
//        }
//        // If the start time is 23 we want the end time to be 0.
//        if (startTime == 23){
//            this.endTime = 0;
//            // note midnight is 00:00 and 24:00 !
//        } else {
//            this.endTime = startTime + 1;
//        }
//
//    }
//}
