package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class DoctorMain extends AppCompatActivity {

    private ListView docNextAppLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main);

        IntializePatientNextApptListView();
    }

//
//    public void getApptClicked(){
//        docNextAppLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String dateString = (String) parent.getItemAtPosition(position);
//                System.out.println("i picked date: " + dateString);
//                getApptObjectClickedOn(dateString);
//            }
//        });
//    }
//
//    public void getApptObjectClickedOn(String dateString){
//        Date date_clickedOn = nextAvail.get(dateString);
//        System.out.println("I SELECTED APPT---: " + date_clickedOn.toString());
//        System.out.println("I SELECTED APPT: " + date_clickedOn.getYear() + "/" + date_clickedOn.getMonth() + "/" + date_clickedOn.getDate());
//
//    }


    public void IntializePatientNextApptListView() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ArrayList<String> nextApptStrings = new ArrayList<String>();

        docNextAppLV = (ListView) findViewById(R.id.DocMainNextAppointmentsLV);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.doc_display_, R.id.DocInfo, nextApptStrings);
        ref = FirebaseDatabase.getInstance().getReference("Doctors/" + FirebaseAuth.getInstance().getCurrentUser().getUid());

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Doctor doc = snapshot.getValue(Doctor.class);
                ArrayList<Appointment> upcome = (ArrayList<Appointment>) doc.upcomingAppts;
                if (upcome == null) {
                    upcome = new ArrayList<Appointment>();
                }
                for (Appointment ap : upcome) {
                    nextApptStrings.add(ap.dateAndTime.toString());
                }
                docNextAppLV.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
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

    @Override
    public void onResume() {
        super.onResume();
        TextView textview = (TextView) findViewById(R.id.doctorLoggedInDoctorMain);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            textview.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        }
    }
}