package com.example.cscb07project_patientappointmentapp.Objects;

import com.example.cscb07project_patientappointmentapp.Adapters.DoctorIDtoDoctorAdapter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Patient extends Person {

    ArrayList<Appointment> appointments;

    public Patient(String fullName, String username, String password, String gender) {
        super(fullName, username, password, gender);
    }

    public void bookAppointment(Timestamp apppointmentTime, String doctorID, String description) {
        Doctor doctor = DoctorIDtoDoctorAdapter.getDoctor(doctorID);
        Appointment appointment = new Appointment(doctor,this, apppointmentTime, description);

        doctor.appointments.add(appointment);
        this.appointments.add(appointment);
    }

    public Map<Doctor, ArrayList<Timestamp>> displayAvailabilityOfDoctors(ArrayList<Doctor> doctors) {
        /*
        Returns a Map of timestamps when the doctors are busy.
         */

        Map<Doctor, ArrayList<Timestamp>> busyTimestamps = new HashMap<Doctor, ArrayList<Timestamp>>();

        for (Doctor d : doctors){
            ArrayList<Timestamp> busy = new ArrayList<Timestamp>();
            for (Appointment t : d.appointments){
                busy.add(t.startTime);
            }

            busyTimestamps.put(d, busy);
        }

        return busyTimestamps;
    }

}

