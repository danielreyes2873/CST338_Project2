package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        View adminLoginButton = findViewById(R.id.confirm_admin_login_button);
        adminLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText uinput;
        EditText pinput;
        String inputU;
        String inputP;

        uinput = (EditText)findViewById(R.id.cinput_admin_username);
        inputU = uinput.getText().toString();
        pinput = (EditText)findViewById(R.id.cinput_admin_password);
        inputP = pinput.getText().toString();

        if(inputU.equals("!admin2") && inputP.equals("!admin2")) {
            success();
            startActivity(new Intent(this, TransactionLog.class));

        }
        else {
            loginError();
            startActivity(new Intent(this, AdminLoginLastTry.class));
        }
    }

    public void loginError() {
        String msg = "Incorrect Username or Password.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void success() {
        String msg = "Login successful";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}