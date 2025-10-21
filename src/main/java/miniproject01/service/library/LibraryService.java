package miniproject01.service.library;

import miniproject01.dto.Book;
import miniproject01.dto.Member;

import java.util.List;

public interface LibraryService {

    boolean addMember(Member member);

    boolean addBook(Book book);

    List<Member> listAllMembers();

    List<Book> listAllBooks();

    List<Member> findMemberByName(String name);

    List<Book> findBookByTitle(String title);

    boolean rentBook(Long bookId, Long memberId);

    boolean returnBook(Long bookId);

    List<Book> listRentedBooks();

    boolean rentedBookEmpty();
}
