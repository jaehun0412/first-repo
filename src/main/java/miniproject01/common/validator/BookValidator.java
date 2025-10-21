package miniproject01.common.validator;

import miniproject01.dto.Book;
import miniproject01.repository.book.BookRepository;

public class BookValidator {

    // 도서 등록 검증
    // TODO: 더 많은 예외 상황 검증
    public static void isValidBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("도서 제목은 공백일 수 없습니다.");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("저자는 공백일 수 없습니다.");
        }
    }

    // TODO: 도서 검색 검증
    public static void searchValid(BookRepository bookRepository, String searchTitle) {
        if (bookRepository.isEmpty()) {
            throw new RuntimeException("등록된 도서가 없습니다.");
        }

        if (searchTitle == null || searchTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("공백으로 검색할 수 없습니다.");
        }
    }
}
