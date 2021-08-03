package com.example.cscb07project_patientappointmentapp;

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

    public Doctor(String fullName, String username, String gender, String specialty) {
        super(fullName, username, gender);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
    }

}
