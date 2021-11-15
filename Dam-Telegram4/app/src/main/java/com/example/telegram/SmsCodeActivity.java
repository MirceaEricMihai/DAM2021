package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsCodeActivity extends AppCompatActivity {
    private Button btnSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_code);


        btnSMS = (Button) findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openSmsCodeActivity(); }
        });
    }
    public void openSmsCodeActivity(){
        Intent intent = new Intent(this, SignUpInfoActivity.class);
        startActivity(intent);
    }
    }
