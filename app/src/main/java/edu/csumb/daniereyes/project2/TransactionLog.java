package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class TransactionLog extends AppCompatActivity implements View.OnClickListener {

    private TransactionDb tr;
    private List<Transaction> trList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_log);
        tr = TransactionDb.getInstance(this);

        TextView list = findViewById(R.id.log_textview);

        trList = tr.transaction().getAll();

        StringBuilder listOfTransactions = new StringBuilder();

        for(Transaction tr : trList) {
            listOfTransactions.append(tr.toString());
        }

        list.setText(listOfTransactions);

        View okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, AddBookPrompt.class));
    }
}