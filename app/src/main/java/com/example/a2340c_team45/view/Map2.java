package com.example.a2340c_team45.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2340c_team45.R;

public class Map2 extends AppCompatActivity {
    private Button map2Next;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map2);


        map2Next = findViewById(R.id.map2_next);

        map2Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map3.class);
                startActivity(intent);
            }
        });
    }
}
