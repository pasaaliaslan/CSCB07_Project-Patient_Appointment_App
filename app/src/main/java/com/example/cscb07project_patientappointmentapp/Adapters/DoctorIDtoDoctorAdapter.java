package com.example.cscb07project_patientappointmentapp.Adapters;

import com.example.cscb07project_patientappointmentapp.Objects.*;

import java.sql.Timestamp;

public class DoctorIDtoDoctorAdapter {
    // Create a function that returns doctor object corresponding to the doctor ID

    public static Doctor getDoctor(String doctorID){
        // Search doctor in the database here and act accordingly
        Timestamp startTime = new Timestamp(2021, 8, 8, 00, 00, 00, 00);
        Timestamp endTime = new Timestamp(2021, 8, 8, 00, 00, 00, 00);

        Doctor doctor = new Doctor("asd", "asd","asd","MALE","IMMUNOLOGY", startTime, endTime);

        return doctor;
    }
}
