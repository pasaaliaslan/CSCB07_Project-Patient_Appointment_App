package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.cscb07project_patientappointmentapp.Objects.Appointment;
import com.example.cscb07project_patientappointmentapp.Objects.Doctor;
import com.example.cscb07project_patientappointmentapp.Objects.Patient;
import com.example.cscb07project_patientappointmentapp.Objects.UID;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String FULLNAME_KEY = "fullname";
    public static final String USERNAME_KEY = "username";
    public static final String GENDER_KEY = "gender";
    public static final String APPOINTMENTS_KEY = "appointment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        DocumentReference df = db.document("/Patients/someid");
//
//        Map<Object, Object> p1 = new HashMap<Object, Object>();
//        p1.put(FULLNAME_KEY, "Pasa Aslan");
//        p1.put(USERNAME_KEY, "pssln");
//        p1.put(GENDER_KEY, "MALE");
//        p1.put(APPOINTMENTS_KEY, new ArrayList().toArray());
//        df.set(p1).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                Log.d(TAG, "Document has been saved!");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w(TAG, "Document is not saved");
//            }
//        });

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        Timestamp startDate = new Timestamp(123456789, 0);
        Timestamp endDate = new Timestamp(987654321, 0);

        UID doctorUID = UID.createUID(database, "doctors");
        UID patientUID = UID.createUID(database, "patients");

        Patient p = new Patient("asadasd", "lolol", "CuteRabbit38", "male", "2021-08-08", patientUID);
        Doctor d = new Doctor("first doctor", "frstdctr", "GoofyDoggie96", "male", "immunology", startDate, endDate, doctorUID);

        UID appointmentUID = UID.createUID(database, "appointment");

        Appointment a1 = new Appointment(d, p,startDate, "asdfghhj", appointmentUID);


    }
}