package com.example.cscb07project_patientappointmentapp;

import java.util.List;

public class Doctor extends Person{

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
    List<Appointment> appointments;

    public Doctor(String fullName, String username, String password, String gender, String specialty) {
        super(fullName, username, password, gender);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
    }

    public String createAppointments(int start, int end){
        int count = start;
        while (count >= start && count < end){
            Appointment appt = new Appointment(this, count);
            this.appointments.add(appt);
            count += 1;
        }
        return("You have booked "+this.appointments.size()+" appointments "+"between "+start+" and " +end);
    }

}
