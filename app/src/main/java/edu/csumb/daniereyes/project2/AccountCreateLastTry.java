package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AccountCreateLastTry extends AppCompatActivity implements View.OnClickListener {

    private AccountDb acct;
    private TransactionDb tr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_create_last_try);
        acct = AccountDb.getInstance(this);
        acct.populateInitialData();
        tr = TransactionDb.getInstance(this);

        View confirmButton = findViewById(R.id.confirm_account_button);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText uinput;
        EditText pinput;
        String inputU;
        String inputP;
//        View parent = (View) v.getParent();
//        TextView taskTextView = (TextView) parent.findViewById(R.id.create_acount);
//        String task = String.valueOf(taskTextView.getText());

        if(v.getId() == R.id.confirm_account_button) {
            uinput = (EditText)findViewById(R.id.cinput_edittext_username);
            inputU = uinput.getText().toString();
            pinput = (EditText)findViewById(R.id.cinput_edittext_password);
            inputP = pinput.getText().toString();
            Account account = acct.account().compareByUsername(inputU);

            if(inputU.isEmpty()) {
                blank1();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else if(inputP.isEmpty()) {
                blank2();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else if(!(account == null)) {
                duplicate();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else if(inputU.equals("!admin2")) {
                admin();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
            else{
                acct.account().addAccount(new Account(inputU,inputP));
                tr.transaction().addTransaction(new Transaction(inputU,"", "","New Account"));
                success();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }

        }
    }

    public void blank1() {
        String msg = "You cannot leave the \"Enter Username\" field blank.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void blank2() {
        String msg = "You cannot leave the \"Enter Password\" field blank.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void duplicate() {
        String msg = "Username already exists.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void admin() {
        String msg = "Username reserved for Library Staff.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void success() {
        String msg = "Account created successfully.";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}