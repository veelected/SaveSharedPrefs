package com.example.bladesharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    String username, lusername;
    SharedPreferences sharedPreferences;
    String SHARED_PREFS = "shared prefs";
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
                saveData();
            }
        });

        loadData();
        updateViews();
    }

    private void saveData() {
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString(username, textView.getText().toString());
        editor.apply();

        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        lusername = sharedPreferences.getString(username, "No name");
    }


    private void updateViews() {
        textView.setText(lusername);
    }

}