package miniproject01.repository.library;

import miniproject01.dto.Book;
import miniproject01.dto.Member;

import java.util.List;

public interface LibraryDAO {

    void rentBook(Book book, Member member);

    void returnBook(Book book);

    List<Book> listRentedBooks();

    boolean rentedBookEmpty();
}
