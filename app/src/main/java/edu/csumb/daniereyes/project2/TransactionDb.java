package edu.csumb.daniereyes.project2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//I iterated the version to get a fresh database. Versions 1-5 have all been used and manipulated already. 6 and on have not been used yet.
@Database(entities = {Transaction.class}, version=6, exportSchema = false)
public abstract class TransactionDb extends RoomDatabase {
    public abstract TransactionDao transaction();
    private static TransactionDb sInstance;
    public static synchronized TransactionDb getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room
                    .databaseBuilder(context.getApplicationContext(),
                            TransactionDb.class,
                            "transactions.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }
}
