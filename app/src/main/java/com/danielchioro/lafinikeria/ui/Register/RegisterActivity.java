package com.danielchioro.lafinikeria.ui.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.danielchioro.lafinikeria.R;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private TextView emailTextView;
    private TextView passwordTextView;
    private TextView passwrordConfirmTextView;

    private RegisterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);


    }

    private void setupView() {
        registerButton = findViewById(R.id.register_button);
        emailTextView = findViewById(R.id.register_email_editText);
        passwordTextView = findViewById(R.id.register_password_editText);

        registerButton.setOnClickListener(onRegisterButtonPress);
    }

    private boolean validateActivity() {
        return false;
    }

    View.OnClickListener onRegisterButtonPress = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(validateActivity()) {
                String userEmail = emailTextView.getText().toString();
            }
//            viewModel.createUser
        }
    };
}
