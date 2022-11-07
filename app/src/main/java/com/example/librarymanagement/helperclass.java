package com.example.librarymanagement;

public class helperclass {

    String BookName , ISBN , Availability,Reserve_Status;

    public helperclass() {
    }

    public helperclass(String bookName, String ISBN, String availability, String reserve_Status) {
        BookName = bookName;
        this.ISBN = ISBN;
        Availability = availability;
        Reserve_Status = reserve_Status;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

    public String getReserve_Status() {
        return Reserve_Status;
    }

    public void setReserve_Status(String reserve_Status) {
        Reserve_Status = reserve_Status;
    }
}
