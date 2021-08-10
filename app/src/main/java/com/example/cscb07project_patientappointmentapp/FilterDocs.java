package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.HashSet;

public class FilterDocs extends AppCompatActivity {

    HashMap<String, Doctor> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_docs);

//        Intent intent = getIntent();
//        map = (HashMap<String, Doctor>)intent.getSerializableExtra("mapper");
//        Doctor gotten = map.get("alinamaria.buzila@gmail.com");
//        if (gotten != null){
//            System.out.println(" GOT ITT: " + gotten.getUsername() + ", " + gotten.getFullName() + ", " + gotten.getSpecialty());
//        }else{
//            System.out.println("COULD NOT GET\n");
//        }
    }

    public void startFilteringThroughDocs(View view){

        Spinner genderSpinner = (Spinner) findViewById(R.id.genderSpinnerFilterDoc);
        String gender = String.valueOf(genderSpinner.getSelectedItem());
        Spinner specializationSpinner = (Spinner) findViewById(R.id.doctorSpecializationFilterDoc);
        String specialization = String.valueOf(specializationSpinner.getSelectedItem());



    }


    public void signOutFromFilterDocs(View view){
        FirebaseAuth.getInstance().signOut();
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            System.out.println("PAT: After sign out: User == null\n");
        }else{
            System.out.println("PAT: After sign out: User != null ...... email adress: " + FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}