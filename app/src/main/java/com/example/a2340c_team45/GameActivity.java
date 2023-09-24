package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    TextView reciever_msg_name;
    TextView reciever_mag_diff;
    TextView starting_hp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        reciever_msg_name = findViewById(R.id.textView2);
        reciever_mag_diff = findViewById(R.id.sel_diff_id);
        starting_hp = findViewById(R.id.starting_hp_id);
        int diff = getIntent().getIntExtra("diff", 1);
        String diff_str = String.valueOf(diff);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        reciever_msg_name.setText(name);
        reciever_mag_diff.setText(diff_str);
        if(diff == 1){

            starting_hp.setText("100");
        }else if(diff == 2){

            starting_hp.setText("75");
        }else{
            starting_hp.setText("50");
        }






    }


}