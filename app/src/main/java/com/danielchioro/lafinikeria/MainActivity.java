package com.danielchioro.lafinikeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielchioro.lafinikeria.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

//        mLoginButton = findViewById(R.id.login_button);
//        mPassword = findViewById(R.id.password_editText);
//        mPassword = findViewById(R.id.email_editText);
//        mMainFragment = new MainFragment();
//        setFragment(mMainFragment);

//        mLoginButton.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String email = (String) mEmail.getText();
//                String password = (String) mPassword.getText();
////                onLogin(email, password);
//            }
//        });
    }

    public void setFragment(Fragment frag) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentById(R.id.container) == null) {
            fm.beginTransaction().add(R.id.container, frag).commit();
        }
    }

//    @Override
//    public void onLogin(String email, String password) {
////        mMainFragment
//    }
}
