package miniproject01.repository.book;

import miniproject01.dto.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findAll();

    List<Book> findByTitle(String title);

    Book findById(Long bookId);

    boolean isEmpty();
}
