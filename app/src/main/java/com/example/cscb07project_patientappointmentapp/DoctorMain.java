package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class DoctorMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);
    }


    public void signOutFromDoctorMain(View view){
        FirebaseAuth.getInstance().signOut();
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            System.out.println("Doc: After sign out: User == null\n");
        }else{
            System.out.println("Doc: After sign out: User != null ...... email adress: " + FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}