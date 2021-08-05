package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference();
//
//        Patient p5 = new Patient("asadasd", "lolol", "CuteRabbit38", "male");
//        Doctor d1 = new Doctor("first doctor", "frstdctr", "GoofyDoggie96", "male","immunology");
//
//        ref.child("Patients").child("p5").setValue(p5);
//        ref.child("Doctors").child("d1").setValue(d1);

    }


    /** Called when the user taps the Patient button */
    public void LoginAsPatient(View view) {
        Intent intent = new Intent(this, PatientNextAppointments.class);
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
//        String message = editText.getText().toString();

//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the Doctor button */
    public void LoginAsDoctor(View view) {
        Intent intent = new Intent(this, DoctorMain.class);
//        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
//        String message = editText.getText().toString();

//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}