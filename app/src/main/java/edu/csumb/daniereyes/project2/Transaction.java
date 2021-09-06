package edu.csumb.daniereyes.project2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "customerUsername")
    private String customerUsername;
    @ColumnInfo(name = "bookTitle")
    private String bookTitle;
    @ColumnInfo(name = "reservationNumber")
    private String reservationNumber;
    @ColumnInfo(name = "transactionType")
    private String transactionType;

    public Transaction(String customerUsername, String bookTitle, String reservationNumber, String transactionType) {
        this.customerUsername = customerUsername;
        this.bookTitle = bookTitle;
        this.reservationNumber = reservationNumber;
        this.transactionType = transactionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        if((bookTitle.equals("")) && (reservationNumber.equals(""))) {
            return "ID: " + id + " Customer Username: " + customerUsername
                    + " Transaction Type: " + transactionType + "\n";
        }
        else {
            return "ID: " + id + " Customer Username: " + customerUsername
                    + " Book Title: " + bookTitle + " Reservation Number: " + reservationNumber
                    + " Transaction Type: " + transactionType + "\n";
        }

    }
}
