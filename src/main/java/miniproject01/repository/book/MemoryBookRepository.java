package miniproject01.repository.book;

import miniproject01.dto.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryBookRepository implements BookRepository {

    private Map<Long, Book> bookMap;

    public MemoryBookRepository() {
        bookMap = new HashMap<>();
    }

    @Override
    public void save(Book book) {
        bookMap.put(book.getBookId(), book);
    }

    @Override
    public List<Book> findAll() {
        return bookMap.values().stream().toList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookMap.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .filter(book -> book.getTitle().contains(title))
                .toList();
    }

    @Override
    public Book findById(Long bookId) {
        return bookMap.get(bookId);
    }

    @Override
    public boolean isEmpty() {
        return bookMap.isEmpty();
    }
}
