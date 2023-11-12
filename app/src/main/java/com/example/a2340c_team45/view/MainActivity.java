package com.example.a2340c_team45.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2340c_team45.R;

public class MainActivity extends AppCompatActivity {
    private Button strButton;
    private Button extButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strButton = findViewById(R.id.button);
        extButton = findViewById(R.id.button2);
        strButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
                startActivities(new Intent[]{intent});
            }
        });

        extButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });



    }
}