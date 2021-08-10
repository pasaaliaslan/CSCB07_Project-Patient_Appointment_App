package com.example.cscb07project_patientappointmentapp;

import java.util.regex.Pattern;

public class AppointmentTime {

        private final Pattern DATE_PATTERN = Pattern.compile("^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/((19|2[0-9])[0-9]{2})$");

        String date;
        int time;

        public AppointmentTime (){}

        public AppointmentTime(String date, int time) {
            if (time < 9 || time > 16) {
                throw new IllegalArgumentException("Invalid Time");
            }

            if (!DATE_PATTERN.matcher(date).matches()) {
                throw new IllegalArgumentException("Invalid Date");
            }

            this.time = time;
            this.date = date;
        }

        public String getDate() { return date; }

        public void setDate(String date) { this.date = date; }

        public int getTime() { return time; }

        public void setTime(int time) { this.time = time; }

}
