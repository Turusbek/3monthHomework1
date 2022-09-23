package com.example.a3monthhomework1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    EditText etGmail,etSubject,etMassage;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGmail = (EditText) findViewById(R.id.et_gmail);
        etSubject = (EditText) findViewById(R.id.et_subject);
        etMassage = (EditText) findViewById(R.id.et_massage);
        btnSend = findViewById(R.id.button);

        openEmail();
    }

    private void openEmail() {
        btnSend.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/html");
            intent.putExtra(Intent.EXTRA_EMAIL, etGmail.getText().toString());
            intent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT,etMassage.getText().toString());
            startActivity(Intent.createChooser(intent, "Send Email"));
        });
     }
    }
