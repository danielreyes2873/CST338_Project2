package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View accountButton = findViewById(R.id.account_button);
        View holdButton = findViewById(R.id.hold_button);
        View manageButton = findViewById(R.id.manage_button);
        accountButton.setOnClickListener(this);
        holdButton.setOnClickListener(this);
        manageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.account_button) {
            Intent i = new Intent(this, AccountCreate.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.hold_button) {
            Intent i = new Intent(this, ChooseGenre.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.manage_button) {
            Intent i = new Intent(this, AdminLogin.class);
            startActivity(i);
        }
    }
}