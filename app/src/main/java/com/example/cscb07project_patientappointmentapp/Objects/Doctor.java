package com.example.cscb07project_patientappointmentapp.Objects;


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
    Timestamp startDuty;
    Timestamp endDuty;
    HashSet<Patient> patients;

    public Doctor(String fullName, String username, String password, String gender, String specialty, Timestamp startDuty, Timestamp endDuty) {
        super(fullName, username, password, gender);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
        this.startDuty = startDuty;
        this.endDuty = endDuty;
        this.patients = new HashSet<Patient>();
    }

    public ArrayList<Appointment> seeNextAppointment(){
        ArrayList<Appointment> nextAppointments = new ArrayList<Appointment>();

        for (int i = 0; i < 5 || i < upcomingAppointments.size(); i++){
            nextAppointments.add(upcomingAppointments.get(i));
        }

        return nextAppointments;
    }

}
