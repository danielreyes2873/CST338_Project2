package edu.csumb.daniereyes.project2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountDao {
    @Insert
    void addAccount(Account account);
    @Query("SELECT COUNT(*) FROM accounts")
    int count();
    @Query("select * from accounts")
    List<Account> getAllAccounts();
    @Query("select * from accounts where username = :accountString")
    Account compareByUsername(String accountString);
    @Query("select * from accounts where password = :accountString")
    Account compareByPassword(String accountString);
    @Query("delete from accounts where username = :accountString")
    void deleteByUsername(String accountString);
    @Query("delete from accounts where password = :accountString")
    void deleteByPassword(String accountString);
}
