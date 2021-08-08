package com.example.cscb07project_patientappointmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_doctor);
    }

    public int verifySignUpInfoDoc(int fulln, int usern, int pass, int passConfirm){
        System.out.println("got to verify doc sign up info\n");

        EditText editTextFullName = (EditText) findViewById(fulln);
        String fullname = editTextFullName.getText().toString();

        System.out.println("got step 2\n");

        EditText editTextUsername = (EditText) findViewById(usern);
        String username = editTextUsername.getText().toString();

        System.out.println("got step 3\n");

        EditText editTextPassword = (EditText) findViewById(pass);
        String password = editTextPassword.getText().toString();

        System.out.println("got step 4\n");

        EditText editTextConfirmPassword = (EditText) findViewById(passConfirm);
        String passwordConfirm = editTextConfirmPassword.getText().toString();

        System.out.println("got step 5\n");

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
        System.out.println("got to the part\n");
        return 0;

    }

    /** Called when the user taps the CREATE ACCOUNT button */
    public void CreateDoctorAccount(View view) {
        Intent intent = new Intent(this, DoctorMain.class);

        int success = verifySignUpInfoDoc(R.id.signUpFullNameDoc, R.id.signUpUsernameDoc, R.id.signUpPasswordDoc, R.id.signUpPasswordConfirmDoc);
        if (success == 1){
            System.out.println("beachy \n");
            return;
        }
        System.out.println("where am i getting lost\n");
        EditText editTextFullName = (EditText) findViewById(R.id.signUpFullNameDoc);
        String fullname = editTextFullName.getText().toString();
        EditText editTextUsername = (EditText) findViewById(R.id.signUpUsernameDoc);
        String username = editTextUsername.getText().toString();
        EditText editTextPassword = (EditText) findViewById(R.id.signUpPasswordDoc);
        String password = editTextPassword.getText().toString();

        Spinner genderSpinner = (Spinner) findViewById(R.id.genderSpinnerDoc);
        String gender = String.valueOf(genderSpinner.getSelectedItem());
        Spinner specializationSpinner = (Spinner) findViewById(R.id.doctorSpecializationSignUpDoc);
        String specialization = String.valueOf(specializationSpinner.getSelectedItem());


        System.out.println("got here\n");
        // authentication check
        FirebaseUser f = FirebaseAuth.getInstance().getCurrentUser();
        if (f == null){
            System.out.println("CURRENT USER IS NULL\n");
        }
        else{
            System.out.println("CURRENT USER NOT NULL ...... email adress: " + FirebaseAuth.getInstance().getCurrentUser().getEmail() + "\n");
        }

        System.out.println("want to create uder : username: " + username + ", password: " + password + "\n");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                System.out.println("got here\n");
                if (task.isSuccessful()){
                    //create patient object, add to firebase
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    Doctor p1 = new Doctor(fullname, username, password, gender, specialization);
                    ref.child("Doctors").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(p1);

                    startActivity(intent);

                }
                else{
                    System.out.println("Error creating new user -by alina\n");
                }
            }
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                if (e instanceof FirebaseAuthInvalidCredentialsException) {
//                    notifyUser("Invalid password");
//                } else if (e instanceof FirebaseAuthInvalidUserException) {
//
//                    String errorCode =
//                            ((FirebaseAuthInvalidUserException) e).getErrorCode();
//
//                    if (errorCode.equals("ERROR_USER_NOT_FOUND")) {
//                        notifyUser("No matching account found");
//                    } else if (errorCode.equals("ERROR_USER_DISABLED")) {
//                        notifyUser("User account has been disabled");
//                    } else {
//                        notifyUser(e.getLocalizedMessage());
//                    }
//                }
//            }
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