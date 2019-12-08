package com.danielchioro.lafinikeria.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private Button mLoginButton;
    private TextView mPassword;
    private TextView mEmail;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

        mLoginButton = getActivity().findViewById(R.id.login_button);
        mPassword = getActivity().findViewById(R.id.password_editText);
        mPassword = getActivity().findViewById(R.id.email_editText);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) mEmail.getText();
                String password = (String) mPassword.getText();
                mViewModel.loginUser(email, password);
            }
        });

    }
    
}

