package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    TextView reciever_msg_name;
    TextView reciever_mag_diff;
    TextView starting_hp;
    Button endButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        reciever_msg_name = findViewById(R.id.textView2);
        reciever_mag_diff = findViewById(R.id.sel_diff_id);
        starting_hp = findViewById(R.id.starting_hp_id);
        endButton = findViewById(R.id.endButton);
        int diff = getIntent().getIntExtra("diff", 1);
        String diff_str = String.valueOf(diff);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        reciever_msg_name.setText(name);
        reciever_mag_diff.setText(diff_str);

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EndGame.class);
                startActivities(new Intent[]{intent});
            }
        });
        if(diff == 1){

            starting_hp.setText("100");
        }else if(diff == 2){

            starting_hp.setText("75");
        }else{
            starting_hp.setText("50");
        }






    }


}