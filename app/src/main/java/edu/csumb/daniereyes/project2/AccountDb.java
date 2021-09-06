package edu.csumb.daniereyes.project2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//I iterated the version to get a fresh database. Versions 1-5 have all been used and manipulated already. 6 and on have not been used yet.
@Database(entities = {Account.class}, version=6, exportSchema = false)
public abstract class AccountDb extends RoomDatabase {
    public abstract AccountDao account();
    private static AccountDb sInstance;
    public static synchronized AccountDb getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AccountDb.class, "account.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        if(account().count() == 0) {
            runInTransaction(new Runnable() {
                @Override
                public void run() {
                    account().addAccount(new Account("a@lice5",
                            "@csit100"));
                    account().addAccount(new Account("$brian7",
                            "123abc##"));
                    account().addAccount(new Account("!chris12!",
                            "CHRIS12!!"));
                }
            });
        }
    }
}
