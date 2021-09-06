package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ConfirmHold extends AppCompatActivity implements View.OnClickListener {

    public AccountDb acct;
    private BookDb book;
    private TransactionDb tr;

    private int resNumber = getRandomNumber(1000000,9999999);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_hold);
        acct = AccountDb.getInstance(this);
        acct.populateInitialData();
        book = BookDb.getInstance(this);
        book.populateInitialData();
        tr = TransactionDb.getInstance(this);

        Book selectedBook;

        View yesButton = findViewById(R.id.correct_hold);
        yesButton.setOnClickListener(this);
        View noButton = findViewById(R.id.incorrect_hold);
        noButton.setOnClickListener(this);

        TextView result = findViewById(R.id.result_hold);
        StringBuilder passedString = new StringBuilder();

        Bundle info = getIntent().getExtras();

        if(info != null) {
            passedString.append("Username: " + info.getString("username") + "\n");
            selectedBook = book.book().findByGenre(info.getString("genre"));
            passedString.append("Title: " + selectedBook.getTitle() + "\n");
            passedString.append("Reservation Number: " + resNumber);
            result.setText(passedString);
        }

    }

    @Override
    public void onClick(View v) {
        Bundle info = getIntent().getExtras();
        String username = info.getString("username");
        Book selectedBook = book.book().findByGenre(info.getString("genre"));
        String title = selectedBook.getTitle();

        if(v.getId() == R.id.correct_hold) {
            Toast.makeText(this,"Hold Placed.", Toast.LENGTH_SHORT).show();
            tr.transaction().addTransaction(new Transaction(username, title, Integer.toString(resNumber), "Place Hold"));
            book.book().deleteByTitle(title);
            startActivity(new Intent(this, MainActivity.class));
        }
        else if(v.getId() == R.id.incorrect_hold) {
            startActivity(new Intent(this, ChooseBook.class));
        }

    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}