package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private Button buttonSignIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        BindUI();
        buttonSignIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarCredenciales();
            }
        });
    }

    private void BindUI() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        buttonSignIn2 = findViewById(R.id.buttonSignIn2);
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
        if(getName() == "" || getPassword() == "" || getPasswordConfirm() == "") {
            Toast.makeText(this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Te has registrado con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}