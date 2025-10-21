package miniproject01.service.library;

import miniproject01.common.validator.BookValidator;
import miniproject01.common.validator.MemberValidator;
import miniproject01.dto.Book;
import miniproject01.repository.book.BookRepository;
import miniproject01.dto.Member;
import miniproject01.repository.library.LibraryDAO;
import miniproject01.repository.member.MemberRepository;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    BookRepository bookRepository;
    MemberRepository memberRepository;
    LibraryDAO library;

    public LibraryServiceImpl(BookRepository bookRepository, MemberRepository memberRepository, LibraryDAO library) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.library = library;
    }

    @Override
    public boolean addMember(Member member) {
        try {
            MemberValidator.isValidMember(member);
            memberRepository.save(member);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addBook(Book book) {
        try {
            BookValidator.isValidBook(book);
            bookRepository.save(book);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Member> listAllMembers() {
        if (memberRepository.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return null;
        }

        return memberRepository.findAll();
    }

    @Override
    public List<Book> listAllBooks() {
        if (bookRepository.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return null;
        }

        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        try {
            BookValidator.searchValid(bookRepository, title);
            return bookRepository.findByTitle(title);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Member> findMemberByName(String name) {
        try {
            MemberValidator.searchValid(memberRepository, name);
            return memberRepository.findByName(name);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean rentBook(Long bookId, Long memberId) {
        try {
//            BookValidator.rentValid()
            Book bookById = bookRepository.findById(bookId);
            Member memberById = memberRepository.findById(memberId);

            library.rentBook(bookById, memberById);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean returnBook(Long bookId) {
        try {
//            BookValidator.returnVAlid();
            Book bookById = bookRepository.findById(bookId);

            library.returnBook(bookById);
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Book> listRentedBooks() {
        if (library.rentedBookEmpty()) {
            System.out.println("대여 중인 도서가 없습니다.");
        }

        return library.listRentedBooks();
    }

    @Override
    public boolean rentedBookEmpty() {
        return library.rentedBookEmpty();
    }
}
