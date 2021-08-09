package com.example.cscb07project_patientappointmentapp.Objects;

import android.telecom.Call;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Timeslots {
    List<Integer> timeslot;
    Calendar dateOfSlot;

    public Timeslots() {
        this.timeslot = Arrays.asList(9, 10, 11, 12, 13, 14, 15, 16);
        this.dateOfSlot = Calendar.getInstance();
    }

    public static List<Timeslots> createTimeslots() {
        List<Timeslots> hold = new ArrayList<Timeslots>();
        for (int i = 0; i < 7; i++) { // 0-6
            Timeslots t = new Timeslots();
            t.dateOfSlot.add(Calendar.DATE, i); // Each slot and add 1-6 days to it
            hold.add(t);
        }
        return hold;
    }

    public List<Integer> getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(List<Integer> timeslot) {
        this.timeslot = timeslot;
    }

    public Calendar getDateOfSlot() {
        return dateOfSlot;
    }

    public void setDateOfSlot(Calendar dateOfSlot) {
        this.dateOfSlot = dateOfSlot;
    }
}
