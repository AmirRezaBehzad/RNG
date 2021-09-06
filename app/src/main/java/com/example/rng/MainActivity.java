package com.example.rng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

import static com.example.rng.R.id.from_edittext;
import static com.example.rng.R.id.nl_bottom_navigation;

public class MainActivity extends AppCompatActivity {

    Button startbtn , resetbtn , copybtn;
    EditText fromedittext , toedittext;
    TextView maintxtview , allnumberstxtview;
    Random rand = new Random();
    int from = 0 , to = 0, randnum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromedittext = findViewById(from_edittext);
        toedittext = findViewById(R.id.to_edittext);
        maintxtview = findViewById(R.id.main_text_view);
        allnumberstxtview = findViewById(R.id.all_numbers_text_view);
        allnumberstxtview.setMovementMethod(new ScrollingMovementMethod());

        startbtn = findViewById(R.id.start_btn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fromedittext.getText().toString().equals("") == false && toedittext.getText().toString().equals("") == false) {

                    if (Integer.parseInt(fromedittext.getText().toString()) >= Integer.parseInt(toedittext.getText().toString()))
                    {

                    }
                    else {
                        maintxtview.setText("");
                        from = Integer.parseInt(fromedittext.getText().toString());
                        to = Integer.parseInt(toedittext.getText().toString()) - 1;
                        randnum = Integer.parseInt(String.valueOf(Math.round(Math.random() * (to - from + 1) + from)));
                        maintxtview.setText(String.valueOf(randnum));

                        if (allnumberstxtview.getText().toString().equals(""))
                            allnumberstxtview.setText(String.valueOf(randnum));

                        else {
                            String temp = allnumberstxtview.getText().toString();
                            allnumberstxtview.setText(temp + " " + String.valueOf(randnum));
                        }
                    }
                }
            }
        });

        resetbtn = findViewById(R.id.reset_btn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maintxtview.setText("");
                fromedittext.setText("");
                toedittext.setText("");
                allnumberstxtview.setText("");
            }
        });

        copybtn = findViewById(R.id.copy_button);
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allnumberstxtview.getText().toString().equals(""))
                {

                }
                else
                {
                    String temp = allnumberstxtview.getText().toString();
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Data" , temp);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(),"Copied to Clipboard",Toast.LENGTH_SHORT).show();
                }
            }
        });

        getSupportActionBar().hide();
    }
}