package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextPass;
    private Button buttonLogIn2;

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
    }

    private String getNombre() {
        return editTextNombre.getText().toString().trim();
    }

    private String getPass() {
        return editTextPass.getText().toString().trim();
    }

    private void comprobarCredenciales() {
        if(getNombre() == "" || getPass() == "") {
            Toast.makeText(this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
        } else if(getNombre() == "" && getPass() == ""){
            Toast.makeText(this,"Has iniciado sesión con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Hubo algún error",Toast.LENGTH_SHORT).show();
        }
    }
}