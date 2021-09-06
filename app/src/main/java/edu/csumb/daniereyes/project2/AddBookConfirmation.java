package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddBookConfirmation extends AppCompatActivity implements View.OnClickListener {

    private BookDb book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_confirmation);
        book = BookDb.getInstance(this);
        book.populateInitialData();

        View yesButton = findViewById(R.id.correct_book);
        yesButton.setOnClickListener(this);
        View noButton = findViewById(R.id.incorrect_book);
        noButton.setOnClickListener(this);

        TextView result = findViewById(R.id.result_textview);
        StringBuilder passedString = new StringBuilder();

        Bundle info = getIntent().getExtras();

        if(info != null) {
            passedString.append("Title: " + info.getString("title") + "\n");
            passedString.append("Author: " + info.getString("author") + "\n");
            passedString.append("Genre: " + info.getString("genre"));
            result.setText(passedString);
        }
    }

    @Override
    public void onClick(View v) {
        Bundle info = getIntent().getExtras();
        String inputT = info.getString("title");
        String inputA = info.getString("author");
        String inputG = info.getString("genre");
        Book duplicate = book.book().checkDuplicate(inputT);

        if(v.getId() == R.id.correct_book) {
            if(!(duplicate == null)) {
                startActivity(new Intent(this, DuplicateBook.class));
            }
            else {
                book.book().addBook(new Book(inputT,inputA,inputG));
                startActivity(new Intent(this, MainActivity.class));
            }
        }
        else if(v.getId() == R.id.incorrect_book) {
            startActivity(new Intent(this, AddBook.class));
        }

    }

}