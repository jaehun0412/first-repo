package miniproject01.repository.library;

import miniproject01.dto.Book;
import miniproject01.dto.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryLibraryImpl implements LibraryDAO {

    private Map<Book, Member> rentedBookMap;

    public MemoryLibraryImpl() {
        rentedBookMap = new HashMap<>();
    }

    @Override
    public void rentBook(Book book, Member member) {
        rentedBookMap.put(book, member);
    }

    @Override
    public void returnBook(Book book) {
        rentedBookMap.remove(book);
    }

    @Override
    public List<Book> listRentedBooks() {
        if (rentedBookMap.isEmpty()) {
            System.out.println("대여 중인 도서가 없습니다.");
            return null;
        }

        return rentedBookMap.keySet().stream().toList();
    }

    @Override
    public boolean rentedBookEmpty() {
        return rentedBookMap.isEmpty();
    }
}
