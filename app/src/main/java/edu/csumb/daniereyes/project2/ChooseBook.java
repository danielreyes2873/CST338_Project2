package edu.csumb.daniereyes.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

public class ChooseBook extends AppCompatActivity {

    private BookDb book;
    private Spinner genreSpinner;
    private List<Book> genreList;
    private ArrayAdapter<Book> bookAdapter;

    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_book);
        book = BookDb.getInstance(this);
        book.populateInitialData();

        confirmButton = findViewById(R.id.confirm_genre_button);

        Bundle info = getIntent().getExtras();

        genreList = book.book().getAllGenre(info.getString("genre"));
        genreSpinner = findViewById(R.id.genre_spinner);

        bookAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genreList);

        bookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genreSpinner.setAdapter(bookAdapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Book genreSelected = (Book) genreSpinner.getSelectedItem();

                if(genreSelected != null) {
                    String txt = genreSpinner.getSelectedItem().toString();
                    Log.d("ChooseGenre", genreSelected.getGenre());

                    Intent i = new Intent(ChooseBook.this, HoldLogin.class);
                    Bundle c = new Bundle();
                    c.putString("genre",genreSelected.getGenre());
                    i.putExtras(c);
                    startActivity(i);
                }
            }
        });
    }
}