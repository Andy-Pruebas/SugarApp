package com.vilca.sugarapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vilca.sugarapp.R;
import com.vilca.sugarapp.Repository.UserRepository;

public class RegisterActivity extends AppCompatActivity {
    private EditText fullnameinput,emailinput,passwordinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullnameinput=(EditText) findViewById(R.id.fullname_input);
        emailinput=(EditText) findViewById(R.id.email_input);
        passwordinput=(EditText) findViewById(R.id.password_input);
    }
    public void Registrar(View view){
        String fullname=fullnameinput.getText().toString();
        String email=emailinput.getText().toString();
        String password=passwordinput.getText().toString();
        if(fullname.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"Completar todos los campos",Toast.LENGTH_SHORT).show();
            return;
        }
        UserRepository.create(fullname,email,password);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
