package com.example.e272;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    EditText rpass, rlog;
    Button rbtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        rpass= findViewById(R.id.rpass);
        rbtn = findViewById(R.id.rbtn);
        rlog= findViewById(R.id.rlog);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("rlog",rlog.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        rbtn.setOnClickListener(listener);
    }
}
