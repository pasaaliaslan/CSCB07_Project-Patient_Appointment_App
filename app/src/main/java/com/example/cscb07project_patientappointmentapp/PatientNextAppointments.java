package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class PatientNextAppointments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_next_appointments);

//        onResume(); // i think this is automatically called, no need to call it
    }

    public void signOutFromPatientNextAppointments(View view){
        FirebaseAuth.getInstance().signOut();
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            System.out.println("Patient Next appts: After sign out: User == null\n");
        }else{
            System.out.println("Patient Next appts: After sign out: User != null ...... email adress: " + FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onResume() {
        super.onResume();
        TextView textview = (TextView) findViewById(R.id.PatientLoggedInNextAppts);
        textview.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
    }
}