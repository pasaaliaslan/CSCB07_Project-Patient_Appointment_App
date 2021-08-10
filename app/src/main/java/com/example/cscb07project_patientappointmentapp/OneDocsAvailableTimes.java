package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class OneDocsAvailableTimes extends AppCompatActivity {

//    HashMap<String, Doctor> allDocs;
//    HashMap<String, Doctor> filteredDocs;
//    ArrayList<String> filteredDocsInfo;
    private ListView oneDocAvailabilitiesLV;
    Patient p;
    Appointment bookApp;
    Doctor docClicked;
    ArrayList<String> dateStrings;
    HashMap <String, Date> nextAvail;
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_docs_available_times);

        Intent intent = getIntent();
        docClicked = (Doctor)intent.getSerializableExtra("docClickedOn");
        System.out.println("i clicked the doc: " + docClicked.getFullName() + ", " + docClicked.getUsername());

        oneDocAvailabilitiesLV = (ListView)findViewById(R.id.idLVOneDocAvailabilities);
        createNextFiveAppointments();
        getDateClicked();
    }

    public void createNextFiveAppointments(){
//        ArrayList<Date> nextAvail = docClicked.getNextFiveAvailableAppointments();
//        if (nextAvail == null){
//            System.out.println("nextavail is null\n");
//        }
        nextAvail = docClicked.getNextFiveAvailableAppointments();
        IntializeDocAvailabilitiesListView(nextAvail);
//        System.out.println("here we go\n");
    }


    public void IntializeDocAvailabilitiesListView( HashMap <String, Date> nextAvail){
        dateStrings = new ArrayList<String>();
//        for (Date c: nextAvail){
//            dateStrings.add(c.toString());
//        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.doc_display_,R.id.DocInfo, dateStrings);
        Iterator hashIterator = nextAvail.entrySet().iterator();

        while (hashIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)hashIterator.next();
            Date d1 = (Date)entry.getValue();
            dateStrings.add(d1.toString());
        }
        oneDocAvailabilitiesLV.setAdapter(adapter);
    }

    public void getDateClicked(){
        oneDocAvailabilitiesLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dateString = (String) parent.getItemAtPosition(position);
                System.out.println("i picked date: " + dateString);
                getDateObjectClickedOn(dateString);
            }
        });
    }

    public void getDateObjectClickedOn(String dateString){
        Date date_clickedOn = nextAvail.get(dateString);
        System.out.println("I SELECTED APPT---: " + date_clickedOn.toString());
        System.out.println("I SELECTED APPT: " + date_clickedOn.getYear() + "/" + date_clickedOn.getMonth() + "/" + date_clickedOn.getDate());

        updatePersonInDatabase(date_clickedOn);
//        Intent intent = new Intent(this, OneDocsAvailableTimes.class);
//        intent.putExtra("docClickedOn", d_clickedOn);
//        startActivity(intent);
    }

    public void updatePersonInDatabase(Date datePicked){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        String patientUID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        bookApp = new Appointment(docClicked.my_uid, patientUID, datePicked);
        Map<String, Object> pval = new HashMap<String,Object>();
        Map<String, Object> dval = new HashMap<String,Object>();
        docClicked.addAppointmentToAppointments(bookApp);
        dval.put(docClicked.my_uid, docClicked);

        ref.child("Patients").child(patientUID).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        p = snapshot.getValue(Patient.class);
                        p.addAppointmentToAppointments(bookApp);
                        pval.put(p.my_uid, p);
                        ref.child("Patients").updateChildren(pval);
                    }
                    @Override
                    public void onCancelled(@NonNull  DatabaseError error) {
                        //@org.jetbrains.annotations.NotNull
                    }
                });
        System.out.println("printing p: " + p);
        ref.child("Doctors").updateChildren(dval);

//        Map<String, Object> postValues = new HashMap<String,Object>();
//
//        ref.child("users").child(uidPerson).updateChildren(postValues);

//        ref.child("users").child(uidPerson).addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    Map<String, Object> postValues = new HashMap<String,Object>();
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        postValues.put(snapshot.getKey(),snapshot.getValue());
//                    }
//                    postValues.put("email", email);
//                    postValues.put("firstName", firstName);
//                    postValues.put("lastName", lastName);
//                    ref.child("users").child(uidPerson).updateChildren(postValues);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {}
//            }
//            );
//        }
    }


    public void signOutFromOneDocsAvailabilities(View view){
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