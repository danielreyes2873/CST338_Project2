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

public class ChooseGenre extends AppCompatActivity {

    private BookDb book;
    private Spinner genreSpinner;


    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_book);
        book = BookDb.getInstance(this);
        book.populateInitialData();

        confirmButton = findViewById(R.id.confirm_genre_button);

        genreSpinner = findViewById(R.id.genre_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.genre_array,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genreSpinner.setAdapter(adapter);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String genreSelected = (String) genreSpinner.getSelectedItem();

                if(genreSelected != null) {
                    String txt = genreSpinner.getSelectedItem().toString();
                    Book compare = book.book().findByGenre(txt);
                    if(compare == null) {
                        startActivity(new Intent(ChooseGenre.this, NoBook.class));
                    }
                    else if(!(compare == null)) {
                        Log.d("ChooseGenre", genreSelected);
                        Intent i = new Intent(ChooseGenre.this, ChooseBook.class);
                        Bundle c = new Bundle();
                        c.putString("genre",genreSelected);
                        i.putExtras(c);
                        startActivity(i);
                    }
                }
            }
        });
    }
}