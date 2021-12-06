package com.example.telegram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpInfoActivity extends AppCompatActivity {

    SignUpDate signUpDate;
    Button btnSignup;

    EditText numeText, prenumeText, numarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_info);

        btnSignup = findViewById(R.id.btnSignup);
        numeText = findViewById(R.id.et_firstName);
        prenumeText = findViewById(R.id.et_lastName);
        numarText = findViewById(R.id.editTextPhone);
        signUpDate = new SignUpDate();

        DAOCont dao = new DAOCont();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    signUpDate.setNume(numeText.getText().toString());
                    signUpDate.setPrenume(prenumeText.getText().toString());
                    signUpDate.setNumarTelefon(numarText.getText().toString());

                    Cont cnt = new Cont(numeText.getText().toString(),prenumeText.getText().toString(),numarText.getText().toString());

//                    dao.add(cnt).addOnSuccessListener(suc->{

//                        Toast.makeText(this,"Record is inserted",Toast.LENGTH_SHORT).show();
//                    }).addOnFailureListener(er->{
//                        Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_SHORT).show();
//                    });

                    Toast.makeText(SignUpInfoActivity.this, signUpDate.toString(),Toast.LENGTH_LONG).show();

                    Bundle bundle=new Bundle();
                    bundle.putParcelable("OK", signUpDate);

                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("signUpDateBundle",bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValid() {
        if(numeText.getText().toString().isEmpty()){
            Toast.makeText(SignUpInfoActivity.this, "Please enter surname", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(prenumeText.getText().toString().isEmpty()){
            Toast.makeText(SignUpInfoActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(numarText.getText().toString().isEmpty()){
            Toast.makeText(SignUpInfoActivity.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!isNumarTelefonValid(numarText.getText().toString()))
        {
            Toast.makeText(SignUpInfoActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean isNumarTelefonValid(String numar) {
        String expression = "^[+]?[0-9]{10,13}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(numar);
        return matcher.matches();
    }


}