package com.danielchioro.lafinikeria.ui.Login;

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
import android.widget.Toast;

import com.danielchioro.lafinikeria.MainViewActivity;
import com.danielchioro.lafinikeria.R;
import com.danielchioro.lafinikeria.RegisterActivity;
import com.danielchioro.lafinikeria.ui.MainView.MainViewFragment;

public class LoginFragment extends Fragment implements LoginNavigator {

    private LoginViewModel mViewModel;

    private Button mLoginButton;
//    private Button mRegisterButton;
    private TextView mPassword;
    private TextView mEmail;

    public static LoginFragment newInstance() {
        return new LoginFragment();
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
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        mViewModel.navigator = this;
        // TODO: Use the ViewModel

        mLoginButton = getActivity().findViewById(R.id.login_button);
//        mRegisterButton = getActivity().findViewById(R.id.register_button);
        mPassword = getActivity().findViewById(R.id.password_editText);
        mEmail = getActivity().findViewById(R.id.email_editText);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()) {
                    mViewModel.loginUser(email, password);
                }
            }
        });

//        mRegisterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), RegisterActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onSuccessLogin() {
        Intent intent = new Intent(getContext(), MainViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        //new Toast.makeText(getContext(), error, Toast.LENGTH_LONG);
        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
    }
}

