package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextPass;
    private Button buttonLogIn2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        BindUI();
        buttonLogIn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarCredenciales();
            }
        });
    }

    private void BindUI() {
        editTextNombre = findViewById(R.id.editTextLogInName);
        editTextPass = findViewById(R.id.editTextTLogInPass);
        buttonLogIn2 = findViewById(R.id.buttonLogInConfirm);
        textView = findViewById(R.id.textView);
    }

    private String getNombre() {
        return editTextNombre.getText().toString().trim();
    }

    private String getPass() {
        return editTextPass.getText().toString().trim();
    }

    private void comprobarCredenciales() {
        if(!Objects.equals(Usuario.name, getNombre()) || !Objects.equals(Usuario.pass, getPass())) {
            textView.setText(Usuario.name);
            Toast.makeText(this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Has iniciado sesión con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LogInActivity.this, LogInEnterActivity.class);
            startActivity(intent);
        }
    }
}