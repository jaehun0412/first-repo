package hw2.question03;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Library 클래스:
 * 생성자: 빈 도서관 초기화
 * addBook(Book book): 도서 추가
 * findBookByTitle(String title): 제목으로 도서 검색
 * borrowBook(String title): 제목으로 도서 대출
 * returnBook(String title): 제목으로 도서 반납
 * displayAvailableBooks(): 대출 가능한 도서 목록 출력
 */
public class Library {

    private Map<String, Book> bookMap;

    public Library() {
        bookMap = new HashMap<>();
    }

    // 도서 추가
    public void addBook(Book book) {
        bookMap.put(book.getISBN(), book);
        System.out.println("도서가 등록되었습니다. " + book);
    }

    // 대여 가능한 도서 목록 출력
    public void displayAvailableBooks() {
        System.out.println("대여 가능한 도서 목록");
        Collection<Book> values = bookMap.values();
        for (Book value : values) {
            if (!value.isRented()) {
                System.out.println(" - " + value);
            }
        }
    }

    // 도서 대여
    public void borrowBook(String title) {
        Collection<Book> values = bookMap.values();
        for (Book value : values) {
            if (value.getTitle().equals(title) && !value.isRented()) {
                value.setRented(true);
                System.out.println("'" + value.getTitle() + "' 대여가 완료되었습니다.");
                return;
            }

            if (value.getTitle().equals(title) && value.isRented()) {
                System.out.println("'" + value.getTitle() +"' 이미 대여 중인 책입니다.");
                return;
            }
        }
        System.out.println("해당 도서는 존재하지 않습니다. (" + title + ")");
    }

    // 도서 반납
    public void returnBook(String title) {
        Collection<Book> values = bookMap.values();
        for (Book value : values) {
            if (value.getTitle().equals(title) && value.isRented()) {
                value.setRented(false);
                System.out.println("'" + value.getTitle() + "' 반납이 완료되었습니다.");
                return;
            }

            if (value.getTitle().equals(title) && !value.isRented()) {
                System.out.println("'" + value.getTitle() + "' 대여 중이던 도서가 아닙니다.");
                return;
            }
        }
        System.out.println("해당 도서는 존재하지 않습니다. (" + title + ")");
    }
}
