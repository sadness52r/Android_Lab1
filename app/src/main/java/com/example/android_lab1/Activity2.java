package com.example.android_lab1;

import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private TextView textViewOld;
    private EditText editTextNew;
    private Button bReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        textViewOld = findViewById(R.id.textViewOld);
        editTextNew = findViewById(R.id.editTextNew);
        bReturn = findViewById(R.id.bReturn);

        Intent intent = getIntent();
        String oldText = intent.getStringExtra("textFromAct1");

        textViewOld.setText(oldText);

        bReturn.setOnClickListener(v -> {
            String newText = editTextNew.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("oldText", oldText);
            resultIntent.putExtra("newText", newText);

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}