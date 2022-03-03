package com.example.loginalvaroleiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInEnterActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_enter);
        BindUI();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retroceder();
            }
        });
    }

    private void BindUI() {
        button = findViewById(R.id.button);
    }

    private void retroceder() {
        Intent intent = new Intent(LogInEnterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}