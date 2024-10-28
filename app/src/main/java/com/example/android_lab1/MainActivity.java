package com.example.android_lab1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    private TextView textViewResult;
    private Button bSendToAct2;
    private EditText editText;

//    @SuppressLint("SetTextI18n")
//    private ActivityResultLauncher<Intent> activity2ResultLauncher =
//            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//                    result -> {
//                        if (result.getResultCode() == RESULT_OK) {
//                            Intent data = result.getData();
//                            if (data != null) {
//                                String oldText = data.getStringExtra("oldText");
//                                String newText = data.getStringExtra("newText");
//
//                                textViewResult.setText(oldText + " " + newText);
//                            }
//                        }
//                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        bSendToAct2 = findViewById(R.id.bSendToAct2);
        textViewResult  = findViewById(R.id.textViewResult);

        bSendToAct2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("textFromAct1", editText.getText().toString());
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("newText") && data.hasExtra("oldText")) {
                String newText = data.getStringExtra("newText");
                String oldText = data.getStringExtra("oldText");
                textViewResult.setText(oldText + " " + newText);
            }
        }
    }
}