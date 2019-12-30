package com.danielchioro.lafinikeria.ui.Register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.danielchioro.lafinikeria.R;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private TextView userNameTextView, businessNameTextView, emailTextView, passwordTextView, passwordConfirmTextView;

    private String password;

    private RegisterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);

        setupView();
    }

    private void setupView() {
        registerButton = findViewById(R.id.register_button);
        userNameTextView = findViewById(R.id.register_username_editText);
        businessNameTextView = findViewById(R.id.register_commercename_editText);
        emailTextView = findViewById(R.id.register_email_editText);
        passwordTextView = findViewById(R.id.register_password_editText);
        passwordConfirmTextView = findViewById(R.id.register_confirm_password_editText);

        setListeners();
    }

    private void setListeners() {
//        passwordTextView.addTextChangedListener(passwordVerifiyer);
        registerButton.setOnClickListener(onRegisterButtonPress);
    }

    private boolean validateActivity() {
        Boolean validation = false;
        String ErrorMessage = "No se puede proseguir con el registro debido a los siguientes errores: \n\n";
        String password = passwordTextView.getText().toString();
        String passwordConfirmation = passwordConfirmTextView.getText().toString();
        String email = emailTextView.getText().toString();
        String name = userNameTextView.getText().toString();
        String businessName = businessNameTextView.getText().toString();
        if(name.isEmpty()) {
            ErrorMessage += "\u2022 No se ingreso nombre de usuario\n";
            validation = false;
        }
        if(email.isEmpty()) {
            ErrorMessage += "\u2022 No se ingreso email\n";
            validation = false;
        }
        if(businessName.isEmpty()) {
            ErrorMessage += "\u2022 No se ingreso nombre de negocio\n";
            validation = false;
        }
        if(password.isEmpty()) {
            ErrorMessage += "\u2022 No se ingreso ninguna contraseña\n";
            validation = false;
        }
        if(!password.equals(passwordConfirmation)) {
            ErrorMessage += "\u2022 Las contraseñas no coinciden\n";
            validation = false;
        }

        ErrorMessage += "\nFavor de corregirlos para proceder con el registro";
        showErrorMessage(ErrorMessage);
        return validation;
    }

    private void showErrorMessage(String message) {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(message);
        dlgAlert.setTitle("Error");
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.EFFECT_HEAVY_CLICK));
        } else {
            //deprecated in API 26
            v.vibrate(500);
        }
    }

    View.OnClickListener onRegisterButtonPress = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(validateActivity()) {
                String userEmail = emailTextView.getText().toString();

                mViewModel.registerUser(userEmail, password);
            }
        }
    };
}
