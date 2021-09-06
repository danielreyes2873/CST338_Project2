package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddBookPrompt extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_prompt);

        View yesButton = findViewById(R.id.yes_button);
        yesButton.setOnClickListener(this);
        View noButton = findViewById(R.id.no_button);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.yes_button) {
            startActivity(new Intent(this, AddBook.class));
        }
        else if(v.getId() == R.id.no_button) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}