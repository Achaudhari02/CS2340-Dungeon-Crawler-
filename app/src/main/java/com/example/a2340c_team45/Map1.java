package com.example.a2340c_team45;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Map1 extends AppCompatActivity {
    private Button map1_next;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map1);

        map1_next = findViewById(R.id.map1_next);

        map1_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map2.class);
                startActivity(intent);
            }
        });
    }
}
