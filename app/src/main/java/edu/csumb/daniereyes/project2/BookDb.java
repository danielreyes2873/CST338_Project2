package edu.csumb.daniereyes.project2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//I iterated the version to get a fresh database. Versions 1-5 have all been used and manipulated already. 6 and on have not been used yet.
@Database(entities = {Book.class}, version=6, exportSchema = false)
public abstract class BookDb extends RoomDatabase {
    public abstract BookDao book();
    private static BookDb sInstance;
    public static synchronized BookDb getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    BookDb.class, "book.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        if(book().count() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    book().addBook(new Book("I Know Why the Caged Bird Sings",
                            "Maya Angelou", "Memoir"));
                    book().addBook(new Book("The Mythical Man-Month",
                            "Fredrick Brooks", "Computer Science"));
                    book().addBook(new Book("Frankenstein",
                            "Mary Shelley", "Fiction"));
                }
            });
        }
    }
}
