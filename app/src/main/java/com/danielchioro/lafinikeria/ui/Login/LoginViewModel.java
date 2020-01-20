package com.danielchioro.lafinikeria.ui.Login;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    LoginNavigator navigator;
    FirebaseAuth auth = FirebaseAuth.getInstance();
//    Intent intent = navigator.getIntent();

    void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    private static final String TAG = "???";

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            task.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Log.d(TAG, "Successfully signed in with email link!");
                                    navigator.onSuccessLogin();
                                }
                            });
                        } else {
                            task.addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    navigator.showError(e.getLocalizedMessage());
                                }
                            });
                        }

                    }
                });

    }

}
