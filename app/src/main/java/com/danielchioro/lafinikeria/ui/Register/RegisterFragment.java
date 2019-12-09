package com.danielchioro.lafinikeria.ui.Register;

import androidx.lifecycle.ViewModelProviders;

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

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;

    private TextView mEmail;
    private TextView mPassword;
    private TextView mConfirmPassword;

    private Button mRegisterButton;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.register_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        // TODO: Use the ViewModel

        mEmail = getActivity().findViewById(R.id.email_editText);
        mPassword = getActivity().findViewById(R.id.password_editText);
        mConfirmPassword = getActivity().findViewById(R.id.confirm_password_editText);

        mRegisterButton = getActivity().findViewById(R.id.register_button);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) mEmail.getText();
                String password = (String) mPassword.getText();
                mViewModel.registerUser(email, password);
            }
        });
    }

}
