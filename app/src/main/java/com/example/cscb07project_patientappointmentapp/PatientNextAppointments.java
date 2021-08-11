package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PatientNextAppointments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_next_appointments);

//        onResume(); // i think this is automatically called, no need to call it
    }


//    public void IntializePatientListView( HashMap<String, Date> nextAvail){
//        dateStrings = new ArrayList<String>();
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.doc_display_,R.id.DocInfo, dateStrings);
//        Iterator hashIterator = nextAvail.entrySet().iterator();
//
//        System.out.println("avali: " + docClicked.getUsername());
//        while (hashIterator.hasNext()) {
//            Map.Entry entry = (Map.Entry)hashIterator.next();
//            Date d1 = (Date)entry.getValue();
//            System.out.println("Availabilities: " + d1.toString());
//            dateStrings.add(d1.toString());
//        }
//        oneDocAvailabilitiesLV.setAdapter(adapter);
//    }




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