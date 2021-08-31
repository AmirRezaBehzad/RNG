package com.example.rng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

import static com.example.rng.R.id.from_edittext;
import static com.example.rng.R.id.nl_bottom_navigation;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    BottomNavigationView bottomNavigationView;
    Button startbtn , resetbtn;
    EditText editText , fromedittext , toedittext , mainedittext2;
    Random rand = new Random();
    int from = 0 , to = 0, randnum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fromedittext = findViewById(from_edittext);
        toedittext = findViewById(R.id.to_edittext);
        editText = findViewById(R.id.main_edit_text);
        editText.setInputType(InputType.TYPE_NULL);

        startbtn = findViewById(R.id.start_btn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fromedittext.getText().toString().equals("") == false && toedittext.getText().toString().equals("") == false) {
                    editText.setText("");
                    from = Integer.parseInt(fromedittext.getText().toString());
                    to = Integer.parseInt(toedittext.getText().toString()) - 1;
                    randnum = Integer.parseInt(String.valueOf(Math.round(Math.random() * (to - from + 1) + from)));
                    editText.setText(String.valueOf(randnum));
                }
            }
        });

        resetbtn = findViewById(R.id.reset_btn);
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
                fromedittext.setText("");
                toedittext.setText("");
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.rng_bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.rng_bottom_navigation:
                        return true;

                    case R.id.nl_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), NumberListActivity1.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        getSupportActionBar().hide();
    }
}