package miniproject01.dto;

import miniproject01.common.generator.BookIdGenerator;

public class Book {

    private Long bookId;
    private String title;
    private String author;
    private boolean isRented;

    public Book(String title, String author) {
        bookId = BookIdGenerator.generateBookId();
        this.title = title;
        this.author = author;
        isRented = false;
    }

    public Book(Long bookId, String title, String author, boolean isRented) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isRented = isRented;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "[" + bookId + "] 제목: " + title + " | 저자: " + author + " | 대여상태: " + (isRented ? "대여 불가" : "대여 가능");
    }
}
