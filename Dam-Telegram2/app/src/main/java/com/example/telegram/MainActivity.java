package com.example.telegram;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private final int MAIN_ACTIVITY_REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==MAIN_ACTIVITY_REQUEST_CODE){
            if(resultCode==RESULT_OK){
                if(data!=null){
                    Bundle bundle=data.getBundleExtra("PersoanaBundle");
                    SignUpDate signUpDate=bundle.getParcelable("OK");
                    textView.setText(signUpDate.toString());
                }
            }
        }
    }


}