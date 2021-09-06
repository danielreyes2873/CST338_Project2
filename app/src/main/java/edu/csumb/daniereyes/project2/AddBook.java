package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddBook extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        View addBookButton = findViewById(R.id.confirm_add_book_button);
        addBookButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText tinput;
        EditText ainput;
        EditText ginput;
        String inputT;
        String inputA;
        String inputG;

        tinput = (EditText)findViewById(R.id.add_book_title);
        inputT = tinput.getText().toString();
        ainput = (EditText)findViewById(R.id.add_book_author);
        inputA = ainput.getText().toString();
        ginput = (EditText)findViewById(R.id.add_book_genre);
        inputG = ginput.getText().toString();

        Intent i = new Intent(this, AddBookConfirmation.class);
        Bundle c = new Bundle();
        c.putString("title", inputT);
        c.putString("author", inputA);
        c.putString("genre", inputG);
        i.putExtras(c);
        startActivity(i);

    }
}