package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        Patient p5 = new Patient("asadasd", "lolol", "male");
        Doctor d1 = new Doctor("first doctor", "frstdctr", "male","immunology");

        ref.child("Patients").child("p5").setValue(p5);
        ref.child("Doctors").child("d1").setValue(d1);

    }
}