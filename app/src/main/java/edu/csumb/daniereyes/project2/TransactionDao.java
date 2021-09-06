package edu.csumb.daniereyes.project2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    void addTransaction(Transaction transaction);

    @Query("SELECT COUNT(*) FROM transactions")
    int count();

    @Query("SELECT * FROM transactions")
    List<Transaction> getAll();

    @Query("delete from transactions where customerUsername and transactionType = :tranString")
    void deleteByUsernameAndType(String tranString);
}
