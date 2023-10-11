package com.example.a2340c_team45;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Map2 extends AppCompatActivity {
    private Button map2_next;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map2);


        map2_next = findViewById(R.id.map2_next);

        map2_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map3.class);
                startActivity(intent);
            }
        });
    }
}
