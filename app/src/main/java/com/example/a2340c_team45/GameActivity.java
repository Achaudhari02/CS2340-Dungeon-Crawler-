package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView reciever_msg_name;
    TextView reciever_mag_diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        reciever_msg_name = findViewById(R.id.textView2);
        reciever_mag_diff = findViewById(R.id.sel_diff_id);
        int diff = getIntent().getIntExtra("diff", 1);
        String diff_str = String.valueOf(diff);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        reciever_msg_name.setText(name);
        reciever_mag_diff.setText(diff_str);





    }


}