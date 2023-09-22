package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
    }

    public static class MainActivity extends AppCompatActivity {

        Button startBtn;
        Button exitBtn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.start_screen);
            startBtn = findViewById(R.id.startButton);
            exitBtn = findViewById(R.id.exitButton);


    //        startBtn.setOnClickListener(new View.OnClickListener() {
    //            @Override
    //            public void onClick(View view) {
    //                Intent intent = new Intent(getApplicationContext(), InitialActivity.class);
    //                startActivities(new Intent[]{intent});
    //            }
    //        });

    //        exitBtn.setOnClickListener(v -> {
    //            finishAffinity();
    //        });
        }
    }
}