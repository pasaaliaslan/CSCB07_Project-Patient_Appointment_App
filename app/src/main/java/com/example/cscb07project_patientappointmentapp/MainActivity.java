package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        FirebaseUser f = FirebaseAuth.getInstance().getCurrentUser();
        if (f == null){
            System.out.println("IN LOGIN CURRENT USER IS NULL\n");
        }
        else{
            System.out.println("IN LOGIN CURRENT USER NOT NULL\n");
        }


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if (task.isSuccessful()){
//                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                    if (user != null){
//
//                    }
                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

//                    String emailadd = FirebaseAuth.getInstance().getCurrentUser().getEmail();
//                    String emailadd2 = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
//                    System.out.println("email of curr user: " + emailadd + "||||| name: " + emailadd2);

                    DatabaseReference docRef = FirebaseDatabase.getInstance().getReference("Doctors/" + uid);
                    docRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                System.out.println("child is a doctor\n");
                                start_DocMain_activ();
                            }
                            else{
                                System.out.println("child is a patient\n");
                                start_PatientMain_activ();
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError error) {
                            System.out.println("it failed - alina\n");
                        }
                    });
                }
                else{
                    System.out.println("login not successful\n");
                    editTextPassword.setError("Login was not sucessful");
                }
            }
        });

    //@org.jetbrains.annotations.NotNull
//        startActivity(intent);
    }

    public void start_DocMain_activ(){
        Intent intent = new Intent(this, DoctorMain.class);
        startActivity(intent);
    }

    public void start_PatientMain_activ(){
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
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}