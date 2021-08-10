package com.example.cscb07project_patientappointmentapp;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Doctor extends Person {

    enum Specialty {
        IMMUNOLOGY,
        ANESTHESIOLOGY,
        DERMATOLOGY,
        DIAGNOSTIC_RADIOLOGY,
        EMERGENCY_MEDICINE,
        FAMILY_MEDICINE,
        INTERNAL_MEDICINE,
        MEDICAL_GENETICS,
        NEUROLOGY,
        NUCLEAR_MEDICINE,
        OBSTETRICS_GYNECOLOGY,
        OPHTHALMOLOGY,
        PATHOLOGY,
        PEDIATRICS,
        PHYSICAL_MEDICINE_REHABILITATION,
        PREVENTIVE_MEDICINE,
        PSYCHIATRY,
        RADIATION_ONCOLOGY,
        SURGERY,
        UROLOGY
    }
    Specialty specialty;
    List<Patient> patients;


    public Doctor(){}

    public Doctor(String fullName, String username, String password, String gender, String specialty) {
        super(fullName, username, password, gender);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
        this.patients = new ArrayList<Patient>();
    }

//    public ArrayList<Appointment> seeNextAppointments(){
//        ArrayList<Appointment> nextAppointments = new ArrayList<>();
//
//        for (int i = 0; i < 5 || i < upcomingAppointments.size(); i++){
//            nextAppointments.add(upcomingAppointments.get(i));
//        }
//
//        return nextAppointments;
//    }

    public Specialty getSpecialty() { return specialty; }

    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }

    public List<Patient> getPatients() { return patients; }

    public void setPatients(List<Patient> patients) { this.patients = patients; }

    //    @Override
//    protected Object clone(){}

}


