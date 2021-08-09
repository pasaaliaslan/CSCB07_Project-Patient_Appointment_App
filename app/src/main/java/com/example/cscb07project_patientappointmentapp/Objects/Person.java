package com.example.cscb07project_patientappointmentapp.Objects;

import java.util.ArrayList;

public abstract class Person {
    protected enum Gender{
        MALE,
        FEMALE
    }

    String fullName;
    String username;
    String password;
    Gender gender;
    ArrayList<Appointment> upcomingAppointments;
    ArrayList<Appointment> pastAppointments;

    public Person(String fullName, String username, String password, String gender){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.gender = Gender.valueOf(gender.toUpperCase());
        this.upcomingAppointments = new ArrayList<>();
        this.pastAppointments = new ArrayList<>();
    }

    public void addAppointmentToAppointments (Appointment appointment, Person p) {
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

    public void updateAppointments {

    };

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

    public String getGender() {
        return gender.toString().toUpperCase();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Appointment> getUpcomingAppointments() { return upcomingAppointments; }

    public void setUpcomingAppointments(ArrayList<Appointment> upcomingAppointments) { this.upcomingAppointments = upcomingAppointments; }

    public ArrayList<Appointment> getPastAppointments() { return pastAppointments; }

    public void setPastAppointments(ArrayList<Appointment> pastAppointments) { this.pastAppointments = pastAppointments; }
}
