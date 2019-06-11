package com.example.digitalhousefoods.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalhousefoods.R;
import com.example.digitalhousefoods.home.HomeActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button btnRegister;
    private Button btnLogin;
    //private Button btnLoginFacebook;
    //private Button btnLoginGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndGoToRegister();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndGoToProfile();
            }
        });
    }

    private void initViews(){
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        //btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
        //btnLoginGoogle = findViewById(R.id.btnLoginGoogle);
    }

    private void validateAndGoToRegister(){
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if(email.isEmpty()){
            textInputLayoutEmail.setError("Email não pode ser vazio");
            return;
        }

        if(password.isEmpty()){
            textInputLayoutPassword.setError("Senha não pode ser vazia");
            return;
        }

        if(email != null && password != null){
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("EMAIL",email);
            intent.putExtras(bundle);

            startActivity(intent);
        }else {
            Snackbar.make(textInputLayoutEmail, "Email ou Senha inválidos", Snackbar.LENGTH_SHORT);
        }

    }

    private void validateAndGoToProfile(){
        String email = textInputLayoutEmail.getEditText().getText().toString();
        String password = textInputLayoutPassword.getEditText().getText().toString();

        if(email.isEmpty()){
            textInputLayoutEmail.setError("Email não pode ser vazio");
            return;
        }

        if(password.isEmpty()){
            textInputLayoutPassword.setError("Senha não pode ser vazia");
            return;
        }

        if(email != null && password != null){
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("EMAIL",email);
            intent.putExtras(bundle);

            startActivity(intent);
        }else {
            Snackbar.make(textInputLayoutEmail, "Email ou Senha inválidos", Snackbar.LENGTH_SHORT);
        }

    }

}