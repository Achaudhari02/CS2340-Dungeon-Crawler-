package com.example.a2340c_team45;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        Button startBtn = findViewById(R.id.startButton);
        Button exitBtn = findViewById(R.id.exitButton);

        startBtn.setOnClickListener(v -> {
            Intent start = new Intent(MainActivity.this, InitialActivity.class);
            startActivity(start);
            finish();
        });

        exitBtn.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}
