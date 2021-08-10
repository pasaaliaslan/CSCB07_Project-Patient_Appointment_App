package com.example.cscb07project_patientappointmentapp;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Patient extends Person {

    String DOB;
    List<Appointment> pastAppointments;
//    ArrayList<String> str;


    public Patient(){ }

    public Patient(String fullName, String username, String password, String gender, String DOB) {
        super(fullName, username, password, gender);
        this.DOB = DOB;
        this.pastAppointments = new ArrayList<Appointment>();
    }


    // No ID needed
//    public void bookAppointment(Appointment app, Doctor doc, String description) {
//        Doctor doctor = DoctorIDtoDoctorAdapter.getDoctor(doctorName, doctorSpecialty, doctorGender);
//        //Need to check for time slots
//
//        Appointment appointment = new Appointment(doctor,this, startTime, description);
//        addAppointmentToAppointments(appointment, doctor);
//        addAppointmentToAppointments(appointment, this);
//        doctor.patients.add(this);
//    }

//    private void addAppointmentToAppointments (UID appointment, Person p) {
//        int n = p.upcomingAppointments.size();
//
//        // Base Case
//        if (p.upcomingAppointments == null || p.upcomingAppointments.size() == 0 || (appointment.startTime.compareTo(p.upcomingAppointments.get(n-1).startTime) < 0)){
//            p.upcomingAppointments.add(appointment);
//        }
//
//        // Induction Step
//        else {
//            for (int i = 0; i < p.upcomingAppointments.size(); i++) {
//                if (p.upcomingAppointments.get(i).startTime.compareTo(appointment.startTime) > 0){
//                    p.upcomingAppointments.add(i, appointment);
//                    break;
//                }
//            }
//        }
//    }

//    public void bookAppointment(Timestamp apppointmentTime, String doctorID, String description, String id) {
//        Doctor doctor = DoctorIDtoDoctorAdapter.getDoctor(doctorID);
//        Appointment appointment = new Appointment(doctor,this, apppointmentTime, description, id);
//
//        addAppointmentToAppointments(appointment, doctor);
//        addAppointmentToAppointments(appointment, this);
//        doctor.patients.add(this);
//    }

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

    public String getDOB() { return DOB; }

    public void setDOB(String DOB) { this.DOB = DOB; }

//    public LinkedHashSet<Appointment> getPastAppointments() { return pastAppointments; }
//
//    public void setPastAppointments(LinkedHashSet<Appointment> pastAppointments) { this.pastAppointments = pastAppointments; }


    public List<Appointment> getPastAppointments() { return pastAppointments; }

    public void setPastAppointments(List<Appointment> pastAppointments) { this.pastAppointments = pastAppointments; }
}






