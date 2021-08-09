package com.example.cscb07project_patientappointmentapp.Objects;

import com.example.cscb07project_patientappointmentapp.Adapters.DoctorIDtoDoctorAdapter;
import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.HashMap;
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

    public ArrayList<Timestamp> displayAvailabilityOfDoctors(Doctor doctor) {
        /*
        Query the data base and return all doctors that are free
        Returns a Map of timestamps when the doctors are busy.
         */

        ArrayList<Timestamp> busyTimestamps = new ArrayList<Timestamp>;

        for (Doctor d : doctors){
            ArrayList<Timestamp> busyTimes = new ArrayList<Timestamp>();
            for (Appointment t : d.upcomingAppointments){
                busyTimes.add(t.startTime);
            }

            busyTimestamps.put(d, busyTimes);
        }

        return busyTimestamps;
    }

}

