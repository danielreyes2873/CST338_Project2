package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HoldLogin extends AppCompatActivity implements View.OnClickListener  {

    private AccountDb acct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold_login);
        acct = AccountDb.getInstance(this);
        acct.populateInitialData();

        View userLoginButton = findViewById(R.id.confirm_user_login_button);
        userLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText uinput;
        EditText pinput;
        String inputU;
        String inputP;

        uinput = (EditText)findViewById(R.id.cinput_user_username);
        inputU = uinput.getText().toString();
        pinput = (EditText)findViewById(R.id.cinput_user_password);
        inputP = pinput.getText().toString();
        Account checkUsername = acct.account().compareByUsername(inputU);
        Account checkPassword = acct.account().compareByPassword(inputP);

        if((checkUsername == null) || (checkPassword == null)) {
            loginError();
            startActivity(new Intent(this, HoldLoginLastTry.class));
        }
        else if(!(checkUsername == null) && !(checkPassword == null)){
            success();
            Intent i = new Intent(this, ConfirmHold.class);
            Bundle info = getIntent().getExtras();
            Bundle c = new Bundle();
            c.putString("genre",info.getString("genre"));
            c.putString("username", inputU);
            i.putExtras(c);
            startActivity(i);
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