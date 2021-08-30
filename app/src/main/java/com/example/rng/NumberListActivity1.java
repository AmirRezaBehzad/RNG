package com.example.rng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NumberListActivity1 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_list1);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        editText = findViewById(R.id.main_edit_text2);
        editText.setInputType(InputType.TYPE_NULL);


        bottomNavigationView.setSelectedItemId(R.id.nl_bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.rng_bottom_navigation:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.nl_bottom_navigation:
                        return true;
                }
                return false;
            }
        });

        getSupportActionBar().hide();
    }
}