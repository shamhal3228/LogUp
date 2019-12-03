package com.example.e272;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_C = 0;
    EditText pass, log;
    Button btn;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pass= findViewById(R.id.pass);
        txt = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);
        log= findViewById(R.id.log);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn:
                        if ( log.getText().toString().equals("log") && pass.getText().toString().equals("pass") ) {
                            txt.setText("Верно");
                        } else {
                            Intent i;
                            log.setText("");
                            pass.setText("");
                            i= new Intent(MainActivity.this,Registration.class);
                            startActivityForResult(i, REQ_C);
                        }
                        break;
                }
            }
        };
        btn.setOnClickListener(listener);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                log.setText(data.getStringExtra("rlog"));
                break;
        }
    }
}