package com.danielchioro.lafinikeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.danielchioro.lafinikeria.ui.Login.LoginFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {

    private FirebaseAuth auth = FirebaseAuth.getInstance();
//    private String emailLink = getIntent().getData().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(this, MainViewActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.main_activity);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, LoginFragment.newInstance())
                        .commitNow();
            }
        }

    }

}
