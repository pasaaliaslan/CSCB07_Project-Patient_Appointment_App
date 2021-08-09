package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListDoctorsActivity extends AppCompatActivity {

    ArrayList<String[]> DocDisplayList;
    TextView[] docTextViews;
    int j =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctors);

        listDoctors();
        System.out.println("SIZERRRRR: " + DocDisplayList.size() + "\n");
        onResume();
    }


   public void listDoctors() {

       String[] a = new String[3];
       DocDisplayList = new ArrayList<String[]>();
       docTextViews = new TextView[7]; //DocDisplayList.size()
        j = 7;

       docTextViews[0] = (TextView) findViewById(R.id.Doc1DocList);
       docTextViews[1] = (TextView) findViewById(R.id.Doc2DocList);
       docTextViews[2] = (TextView) findViewById(R.id.Doc3DocList);
       docTextViews[3] = (TextView) findViewById(R.id.Doc4DocList);
       docTextViews[4] = (TextView) findViewById(R.id.Doc5DocList);
       docTextViews[5] = (TextView) findViewById(R.id.Doc6DocList);
       docTextViews[6] = (TextView) findViewById(R.id.Doc7DocList);


       FirebaseDatabase database = FirebaseDatabase.getInstance();
       DatabaseReference dinosaursRef = database.getReference("Doctors");
       dinosaursRef.orderByChild("fullname").addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, String previousChildName) {
               Doctor doc = snapshot.getValue(Doctor.class);
               a[0] = doc.fullName;
               a[1]= String.valueOf(doc.gender);
               a[2] = String.valueOf(doc.specialty);
               DocDisplayList.add(a);
               System.out.println(snapshot.getKey() + " was " + doc.fullName);
               System.out.println("size in loop: " + DocDisplayList.size() + "\n" );
               j =5;
               System.out.println("j is : " + j);
               displayDocs();

               for (String[] b: DocDisplayList){
                   System.out.println("the list:" +  b[0] + ", " + b[1] +", " + b[2]);
               }
           }
           public void displayDocs(){
    //               System.out.println("dWOOO: oc name: " + a[0] + "speciality: " + a[2] + "\n");
               System.out.println("sizeeee: " + DocDisplayList.size() + "\n" );
               if (DocDisplayList.size() < 7) {
                   int i = 0;
                   for (String[] b: DocDisplayList){
                       System.out.println("yoyoyo\n");
                       if (i < 7 && i < DocDisplayList.size()){
                           docTextViews[i].setText(b[0] + ", " + b[1] +", " + b[2]);
                           System.out.println("doc name: " + b[0] + "speciality: " + b[2]);
                       }
                       i++;
                   }
               }
           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


       System.out.println("sizeeee: " + DocDisplayList.size() + "\n" );
       for (String[] b: DocDisplayList){
           System.out.println("yoyoyo\n");

           System.out.println("HIIIII doc name: " + b[0] + "speciality: " + b[2] + "\n");

       }
//       System.out.println("j is nower: " + j);



//       int i = 0;
//       for (String[] b: DocDisplayList){
//           if (i < 7){
//               docTextViews[i].setText(b[0] + ", " + b[1] +", " + b[2]);
//           }
//       }
//       TextView t = (TextView) findViewById(R.id.Doc1Availabilities);
//       t.setText("ALINAAAAAA");
//       dothis();


   }

//
//    public void dothis() {
//        int i = 0;
//        for (String[] b: DocDisplayList){
//            if (i < 7){
//                docTextViews[i].setText(b[0] + ", " + b[1] +", " + b[2]);
//            }
//        }
//    }

    @Override
    public void onResume() {

        super.onResume();
//        int i = 0;
//        for (String[] b: DocDisplayList){
//            System.out.println("yoyoyo\n");
//            if (i < 7){
//                docTextViews[i].setText(b[0] + ", " + b[1] +", " + b[2]);
//                System.out.println("doc name: " + b[0] + "speciality: " + b[2]);
//            }
//            i++;
//        }
////        System.out.println("First Doc: name: " + DocDisplayList[0][0] + "speciality: " + DocDisplayList[0][2]);
//        TextView t = (TextView) findViewById(R.id.Doc1DocList);
//       t.setText("ALINAAAAAA");
    }
}