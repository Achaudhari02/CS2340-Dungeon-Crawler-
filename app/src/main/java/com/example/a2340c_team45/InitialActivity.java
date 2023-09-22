package com.example.a2340c_team45;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.EditText;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.RadioButton;

public class InitialActivity extends AppCompatActivity {

    ImageButton spr1Button, spr2Button, spr3Button;

    RadioButton easySel, medSel, hardSel;
    EditText name;
    Player player = new Player();
    Bitmap playerImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        name = findViewById(R.id.name);
        spr1Button = findViewById(R.id.spr1Button);
        spr2Button = findViewById(R.id.spr2Button);
        spr3Button = findViewById(R.id.spr3Button);
        easySel = findViewById(R.id.easyDiff);


        spr1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr1Button.getDrawable()).getBitmap();
            }
        });

        spr2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr2Button.getDrawable()).getBitmap();
            }
        });

        spr3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerImagePath = ((BitmapDrawable)spr3Button.getDrawable()).getBitmap();
            }
        });


//        easySel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        medSel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        hardSel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

}