package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public int verifySignUpInfoPatient(int fulln, int usern, int pass, int passConfirm){

        EditText editTextFullName = (EditText) findViewById(fulln);
        String fullname = editTextFullName.getText().toString();

        System.out.println("come catch me \n");

        EditText editTextUsername = (EditText) findViewById(usern);
        String username = editTextUsername.getText().toString();

        EditText editTextPassword = (EditText) findViewById(pass);
        String password = editTextPassword.getText().toString();

        EditText editTextConfirmPassword = (EditText) findViewById(passConfirm);
        String passwordConfirm = editTextConfirmPassword.getText().toString();

        if (fullname.equals("")){
            editTextFullName.setError("Must enter fullname");
            return 1;
        }
        if (username.equals("")) {
            editTextUsername.setError("Must enter username");
            return 1;
        }
        if (password.equals("")){
            editTextPassword.setError("Must enter password");
            return 1;
        }
        if (passwordConfirm.equals("")){
            editTextConfirmPassword.setError("Must confirm password");
            return 1;
        }
        if (!password.equals(passwordConfirm)){
            editTextConfirmPassword.setError("Passwords must match");
            return 1;
        }
        return 0;
    }

    /** Called when the user taps the CREATE ACCOUNT button */
    public void CreatePatientAccount(View view) {
        Intent intent = new Intent(this, PatientNextAppointments.class);

        int success = verifySignUpInfoPatient(R.id.SignUpFullName, R.id.SignUpUsername, R.id.SignUpPassword, R.id.SignUpPasswordConfirm);
        if (success == 1){
            return;
        }
        EditText editTextFullName = (EditText) findViewById(R.id.SignUpFullName);
        String fullname = editTextFullName.getText().toString();
        EditText editTextUsername = (EditText) findViewById(R.id.SignUpUsername);
        String username = editTextUsername.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.SignUpPassword);
        String password = editTextPassword.getText().toString();

        Spinner spinner = (Spinner) findViewById(R.id.GenderSpinner);
        String gender = String.valueOf(spinner.getSelectedItem());


        System.out.println("got here\n");
        // authentication check
        FirebaseUser f = FirebaseAuth.getInstance().getCurrentUser();
        if (f == null){
            System.out.println("CURRENT USER IS NULL\n");
        }
        else{
            System.out.println("CURRENT USER NOT NULL\n");
        }


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                System.out.println("got here\n");
                if (task.isSuccessful()){
                    //create patient object, add to firebase
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                    Patient p2 = new Patient(fullname, username, password, gender);
                    ref.child("Patients").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(p2);

                    startActivity(intent);

                }
                else{
                    System.out.println("Error creating new user -by alina\n");
                    Toast.makeText(SignUpActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
//        FirebaseUser fer = FirebaseAuth.getInstance().getCurrentUser();
//        if (fer == null){
//            System.out.println("after creating user: curr user is null\n");
//        }
//        else{
//            System.out.println("after creating user: curr user is not null\n");
//        }
        //@org.jetbrains.annotations.NotNull

//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
}