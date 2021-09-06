package edu.csumb.daniereyes.project2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);
    @Query("SELECT COUNT(*) FROM books")
    int count();
    @Query("select * from books")
    List<Book> getAllBooks();
    @Query("select * from books where genre = :bookString")
    List<Book> getAllGenre(String bookString);
    @Query("select * from books where genre = :bookString")
    Book findByGenre(String bookString);
    @Query("select * from books where title = :bookString")
    Book checkDuplicate(String bookString);
    @Query("delete from books where title = :bookString")
    void deleteByTitle(String bookString);
}
