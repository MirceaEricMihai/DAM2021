package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button btnPhone;

    EditText et_phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
        et_phoneNumber = (EditText) findViewById(R.id.et_phoneNumber);


        btnPhone = (Button) findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = et_phoneNumber.getText().toString();
                if (et_phoneNumber.equals("") || et_phoneNumber.equals(null)||et_phoneNumber.length()<9) {
                    et_phoneNumber.setError("Enter a right mobile number");
                    return;
                } else {
                    Intent intent = new Intent(getApplicationContext(), SmsCodeActivity.class);
                    startActivity(intent);
                }

            }


        });

    }
}


