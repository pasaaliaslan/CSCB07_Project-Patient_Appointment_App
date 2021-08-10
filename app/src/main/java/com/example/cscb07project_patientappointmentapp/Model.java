package com.example.cscb07project_patientappointmentapp;

import android.app.Activity;
import androidx.annotation.NonNull;

import com.example.cscb07project_patientappointmentapp.quickstart.Contract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Model implements Contract.Model {

    private Contract.onLoginListener mOnLoginListener;

    public Model(Contract.onLoginListener onLoginListener){
        this.mOnLoginListener = onLoginListener;
    }

    @Override
    public void performFirebaseLogin(Activity activity, String email, String password) {

        FirebaseUser f = FirebaseAuth.getInstance().getCurrentUser();
        if (f == null) {
            //System.out.println("IN LOGIN CURRENT USER IS NULL\n");
            mOnLoginListener.onFailure("IN LOGIN CURRENT USER IS NULL\n");
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task == null) {
                    mOnLoginListener.onFailure(task.getException().toString());
                }
                if (task.isSuccessful()) {
                    mOnLoginListener.onSuccess(task.getResult().toString());
                } else {
                    mOnLoginListener.onFailure(task.getException().toString());
                }
            }


        });
    }


}

