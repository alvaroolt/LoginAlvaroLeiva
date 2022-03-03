package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private Button buttonSignIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        BindUI();
        buttonSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarCredenciales();
            }
        });
    }

    private void BindUI() {
        editTextName = findViewById(R.id.editTextSignUpName);
        editTextPassword = findViewById(R.id.editTextSignInPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextSignInPasswordConfirm);
        buttonSignIn2 = findViewById(R.id.buttonSignInConfirm);
    }

    private String getName() {
        return editTextName.getText().toString().trim();
    }

    private String getPassword() {
        return editTextPassword.getText().toString().trim();
    }

    private String getPasswordConfirm() {
        return editTextPasswordConfirm.getText().toString().trim();
    }

    private void comprobarCredenciales() {
        if(getName().isEmpty() || getPassword().isEmpty() || getPasswordConfirm().isEmpty() || !Objects.equals(getPassword(), getPasswordConfirm())) {
            Toast.makeText(this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
        } else {
            Usuario.name = editTextName.getText().toString();
            Usuario.pass = editTextPassword.getText().toString();
            Toast.makeText(this,"Te has registrado con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}