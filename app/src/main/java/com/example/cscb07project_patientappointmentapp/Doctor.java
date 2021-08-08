package com.example.cscb07project_patientappointmentapp;


import com.google.firebase.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;

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
    Timestamp startDuty;
    Timestamp endDuty;
    HashSet<UID> patients;

    public Doctor(String fullName, String username, String password, String gender, String specialty, Timestamp startDuty, Timestamp endDuty, UID uid) {
        super(fullName, username, password, gender, uid);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
        this.startDuty = startDuty;
        this.endDuty = endDuty;
        this.patients = new HashSet<UID>();
    }

    public ArrayList<UID> seeNextAppointment(){
        ArrayList<UID> nextAppointments = new ArrayList<UID>();

        for (int i = 0; i < 5 || i < upcomingAppointments.size(); i++){
            nextAppointments.add(upcomingAppointments.get(i));
        }

        return nextAppointments;
    }

}
