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

    private void addAppointmentToAppointments (Appointment appointment, Person p) {
        int n = p.upcomingAppointments.size();

        // Base Case
        if (p.upcomingAppointments == null || p.upcomingAppointments.size() == 0 || (appointment.startTime.compareTo(p.upcomingAppointments.get(n-1).startTime) < 0)){
            p.upcomingAppointments.add(appointment);
        }

        // Induction Step
        else {
            for (int i = 0; i < p.upcomingAppointments.size(); i++) {
                if (p.upcomingAppointments.get(i).startTime.compareTo(appointment.startTime) > 0){
                    p.upcomingAppointments.add(i, appointment);
                    break;
                }
            }
        }
    }

    public void bookAppointment(Timestamp startTime, String doctorName, String doctorSpecialty, String doctorGender, String description, String id) {
        Doctor doctor = DoctorIDtoDoctorAdapter.getDoctor(doctorName, doctorSpecialty, doctorGender);
        Appointment appointment = new Appointment(doctor,this, startTime, description);
        addAppointmentToAppointments(appointment, doctor);
        addAppointmentToAppointments(appointment, this);
        doctor.patients.add(this);
    }

//    public Map<Doctor, ArrayList<Timestamp>> displayAvailabilityOfDoctors(ArrayList<Doctor> doctors) {
//        /*
//        Returns a Map of timestamps when the doctors are busy.
//         */
//
//        Map<Doctor, ArrayList<Timestamp>> busyTimestamps = new HashMap<Doctor, ArrayList<Timestamp>>();
//
//        for (Doctor d : doctors){
//            ArrayList<Timestamp> busy = new ArrayList<Timestamp>();
//            for (UID t : d.upcomingAppointments){
//                busy.add(t.startTime);
//            }
//
//            busyTimestamps.put(d, busy);
//        }
//
//        return busyTimestamps;
//    }

}

