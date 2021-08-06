package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//package com.google.firebase.quickstart.auth;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (LoginCheckIfCurrUserNull() == 1){
            // curr user != null
            checkIfDocOrPat();
        }


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

    public void checkIfDocOrPat(){
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference docRef = FirebaseDatabase.getInstance().getReference("Doctors/" + uid);
        docRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    System.out.println("user is a doctor\n");
                    updateUIDoc();
                }
                else{
                    System.out.println("user is a patient\n");
                    updateUIPatient();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("user is not doc or patient\n");
            }
        });
    }

    public int LoginCheckIfCurrUserNull(){
        FirebaseUser f = FirebaseAuth.getInstance().getCurrentUser();
        if (f == null){
            System.out.println("IN LOGIN CURRENT USER IS NULL\n");
            return 0;
        }
        else{
            System.out.println("IN LOGIN CURRENT USER NOT NULL ...... email adress: " + FirebaseAuth.getInstance().getCurrentUser().getEmail());
            return 1;
        }
    }

    /** Called when the user taps the Patient button */
    public void UserLogin(View view) {

        EditText editTextUsername = (EditText) findViewById(R.id.MainUsername);
        String username = editTextUsername.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.MainPassword);
        String password = editTextPassword.getText().toString();
        if (username.equals("") ) {
            editTextUsername.setError("Must enter username");
            return;
        }
        if (password.equals("")){
            editTextPassword.setError("Must enter password");
            return;
        }

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if (task.isSuccessful()){
                    checkIfDocOrPat();
                }
                else{
                    System.out.println("login not successful\n");
//                    editTextPassword.setError("Login was not sucessful");
                    Toast.makeText(MainActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    //@org.jetbrains.annotations.NotNull
    }

    public void updateUIDoc(){
        Intent intent = new Intent(this, DoctorMain.class);
        startActivity(intent);
    }

    public void updateUIPatient(){
        Intent intent = new Intent(this, BookAppointmentActivity.class);
        startActivity(intent);
    }


//    /** Called when the user taps the Patient button */
//    public void LoginAsPatient(View view) {
//        Intent intent = new Intent(this, PatientNextAppointments.class);
//
//        EditText editTextUsername = (EditText) findViewById(R.id.MainUsername);
//        String username = editTextUsername.getText().toString();
//
//        EditText editTexPassword = (EditText) findViewById(R.id.MainPassword);
//        String password = editTexPassword.getText().toString();
//
////        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//
////        intent.putExtra(EXTRA_MESSAGE, message);
//        if (username.equals("") ) {
//            editTextUsername.setError("Must enter username");
//            return;
//        }
//        if (password.equals("")){
//            editTexPassword.setError("Must enter password");
//            return;
//        }
//
//
//        startActivity(intent);
//    }

//    /** Called when the user taps the Doctor button */
//    public void LoginAsDoctor(View view) {
//        Intent intent = new Intent(this, DoctorMain.class);
////        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName2);
////        String message = editText.getText().toString();
//
////        intent.putExtra(EXTRA_MESSAGE, message);
//
//        EditText editText = (EditText) findViewById(R.id.MainUsername);
//        String message = editText.getText().toString();
//
//        EditText editText2 = (EditText) findViewById(R.id.MainPassword);
//        String message2 = editText2.getText().toString();
//
////        intent.putExtra(EXTRA_MESSAGE, message);
//        if (!message.equals("") && !message2.equals("")) {
//            startActivity(intent);
//        }
//    }

    /** Called when the user taps the SIGN UP as PATIENT button */
    public void SignUpAsPatient(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the SIGN UP as DOCTOR button */
    public void SignUpAsDoctor(View view) {
        Intent intent = new Intent(this, SignUpDoctor.class);
        startActivity(intent);
    }
}