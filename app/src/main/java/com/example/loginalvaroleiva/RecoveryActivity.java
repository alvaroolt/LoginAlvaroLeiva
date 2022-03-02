package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecoveryActivity extends AppCompatActivity {

    private EditText editTextNombre3;
    private EditText editTextNewPass;
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
        editTextNombre3 = findViewById(R.id.editTextRecoveryName);
        editTextNewPass = findViewById(R.id.editTextRecoveryNewPass);
        buttonConfirmNewPass = findViewById(R.id.buttonConfirmNewPass);
    }

    private String getNombre() {
        return editTextNombre3.getText().toString().trim();
    }

    private String getPass() {
        return editTextNewPass.getText().toString().trim();
    }

    private void comprobarCredenciales() {
        if(getNombre() == "" || getPass() == "") {
            Toast.makeText(this,"Credenciales inválidas",Toast.LENGTH_SHORT).show();
        } else if(getNombre() == "user" && getPass() == "user"){
            Toast.makeText(this,"Cambiaste la contraseña con éxito",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RecoveryActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Hubo algún error",Toast.LENGTH_SHORT).show();
        }
    }
}