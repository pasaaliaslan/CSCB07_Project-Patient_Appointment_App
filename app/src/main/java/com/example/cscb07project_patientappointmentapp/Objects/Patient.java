package com.example.cscb07project_patientappointmentapp.Objects;

import com.example.cscb07project_patientappointmentapp.Adapters.DoctorIDtoDoctorAdapter;
import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patient extends Person {

    String DOB;

    public Patient(String fullName, String username, String password, String gender, String DOB) {
        super(fullName, username, password, gender);
        this.DOB = DOB;
    }


    // No ID needed
    public void bookAppointment(Timestamp startTime, String doctorName, String doctorSpecialty, String doctorGender, String description) {
        Doctor doctor = DoctorIDtoDoctorAdapter.getDoctor(doctorName, doctorSpecialty, doctorGender);
        //Need to check for time slots

        Appointment appointment = new Appointment(doctor,this, startTime, description);
        addAppointmentToAppointments(appointment, doctor);
        addAppointmentToAppointments(appointment, this);
        doctor.patients.add(this);
    }


    }



