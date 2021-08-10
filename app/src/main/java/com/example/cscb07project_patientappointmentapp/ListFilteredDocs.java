package com.example.cscb07project_patientappointmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ListFilteredDocs extends AppCompatActivity {

    HashMap<String, Doctor> allDocs;
    HashMap<String, Doctor> filteredDocs;
    ArrayList<String> filteredDocsInfo;
    private ListView filteredDocsLV;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_filtered_docs);

        Intent intent = getIntent();
        allDocs = (HashMap<String, Doctor>)intent.getSerializableExtra("allDocsMap");
        String genToFilter = intent.getStringExtra("gender_filter");
        String specToFilter = intent.getStringExtra("spec_filter");

        filteredDocsLV = (ListView)findViewById(R.id.idLVOneDocsAvailabilities);
        filteredDocs = new HashMap<>();
        filteredDocsInfo = new ArrayList<String>();

        IntializeListFilteredDocsListView(genToFilter, specToFilter);
//        getDoctorClicked();
    }


    public void IntializeListFilteredDocsListView(String g, String s){

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.doc_display_,R.id.DocInfo, filteredDocsInfo);
        Iterator hashIterator = allDocs.entrySet().iterator();

        while (hashIterator.hasNext()) {
            Map.Entry entry = (Map.Entry)hashIterator.next();
            Doctor d1 = (Doctor)entry.getValue();
            if (d1.getGender().toString().equals(g) && d1.getSpecialty().toString().equals(s)){
                filteredDocsInfo.add(d1.getFullName() + ", " + d1.getUsername() + ", " + d1.getGender().toString() + ", " + d1.getSpecialty().toString());
                filteredDocs.put(d1.getUsername(), d1);
            }
        }
        filteredDocsLV.setAdapter(adapter);
    }


    public void signOutFromListFilteredDocs(View view){
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