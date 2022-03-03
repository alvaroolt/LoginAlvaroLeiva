package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class RecoveryActivity extends AppCompatActivity {

    private EditText editTextRecoveryName;
    private EditText editTextRecoveryNewPass;
    private EditText editTextRecoveryConfirmPass;
    private Button buttonConfirmNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        BindUI();
        buttonConfirmNewPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarCredenciales();
            }
        });
    }

    private void BindUI() {
        editTextRecoveryName = findViewById(R.id.editTextRecoveryName);
        editTextRecoveryNewPass = findViewById(R.id.editTextRecoveryNewPass);
        editTextRecoveryConfirmPass = findViewById(R.id.editTextRecoveryConfirmPass);
        buttonConfirmNewPass = findViewById(R.id.buttonConfirmNewPass);
    }

    private String getNombre() {
        return editTextRecoveryName.getText().toString().trim();
    }

    private String getPass() {
        return editTextRecoveryNewPass.getText().toString().trim();
    }

    private String getConfirmPass() {
        return editTextRecoveryConfirmPass.getText().toString().trim();
    }

    private void comprobarCredenciales() {
        if(!Objects.equals(Usuario.name, getNombre())) {
            Toast.makeText(this,"No existe el usuario",Toast.LENGTH_SHORT).show();
        } else if(!Objects.equals(getPass(), getConfirmPass()) || getPass().isEmpty() || getConfirmPass().isEmpty()){
            Toast.makeText(this,"No coinciden las contraseñas",Toast.LENGTH_SHORT).show();
        } else {
            Usuario.pass = editTextRecoveryNewPass.getText().toString();
            Intent intent = new Intent(RecoveryActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Contraseña actualizada con éxito",Toast.LENGTH_SHORT).show();
        }
    }
}