package hw2.question03;

/**
 * Book 클래스:
 * 생성자: 제목, 저자, ISBN 받기 (대출 가능으로 초기화)
 * borrowBook(): 도서 대출 (가능한 경우만)
 * returnBook(): 도서 반납
 * showBookInfo(): 도서 정보 출력
 */
public class Book {

    private String title;
    private String author;
    private String ISBN;
    private boolean isRented;

    // 생성자
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        isRented = false;
    }

    // 도서 대출 (가능한 경우만)
    public void borrowBook(String title) {

    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "제목: " + title + " | 저자: " + author + " | 상태: " + (isRented ? "대여중" : "대여 가능");
    }
}
