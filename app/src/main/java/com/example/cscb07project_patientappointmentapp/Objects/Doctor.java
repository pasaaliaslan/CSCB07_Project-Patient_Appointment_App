package com.example.cscb07project_patientappointmentapp.Objects;

import com.google.protobuf.TimestampProto;

import java.sql.Timestamp;
import java.util.ArrayList;
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
    ArrayList<Appointment> appointments;
    Timestamp startDuty;
    Timestamp endDuty;

    public Doctor(String fullName, String username, String password, String gender, String specialty, Timestamp startDuty, Timestamp endDuty) {
        super(fullName, username, password, gender);
        this.specialty = Specialty.valueOf(specialty.toUpperCase());
        this.startDuty = startDuty;
        this.endDuty = endDuty;
        this.appointments = new ArrayList<Appointment>();
    }

    // 1st method
    public Appointment seeNextAppointment(){
        // appointments.sort();
        return appointments.get(0);
    }

    // 2nd method
    public void sortAppointment(){
        // Sort by timestamps
    }


}
