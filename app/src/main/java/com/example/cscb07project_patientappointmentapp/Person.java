package com.example.cscb07project_patientappointmentapp;

import com.example.cscb07project_patientappointmentapp.UID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class Person implements Serializable {
    protected enum Gender{
        MALE,
        FEMALE
    }

    String fullName;
    String username;
    String password;
    Gender gender;
    List<Appointment> upcomingAppointments;

    public Person(){}

    public Person(String fullName, String username, String password, String gender){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.upcomingAppointments = new ArrayList<Appointment>();
    }


    public void addAppointmentToAppointments (Appointment appointment) {
        upcomingAppointments.add(appointment);
    }

    // function for get next five appts
//
//    public LinkedHashSet<Appointment> getUpcomingAppointments() { return upcomingAppointments; }
//
//    public void setUpcomingAppointments(LinkedHashSet<Appointment> upcomingAppointments) { this.upcomingAppointments = upcomingAppointments; }


//    public ArrayList<Appointment> getUpcomingAppointments() {
//        return upcomingAppointments;
//    }
//
//    public void setUpcomingAppointments(ArrayList<Appointment> upcomingAppointments) {
//        this.upcomingAppointments = upcomingAppointments;
//    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Gender getGender() {
        return gender;
    }

    public List<Appointment> getUpcomingAppointments() {
        return upcomingAppointments;
    }

    public void setUpcomingAppointments(List<Appointment> upcomingAppointments) {
        this.upcomingAppointments = upcomingAppointments;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    //    public void addAppointmentToAppointments (Appointment appointment, Person p) {
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

}



