package miniproject01.dto;

import miniproject01.repository.book.BookRepository;
import miniproject01.repository.book.MemoryBookRepository;
import miniproject01.repository.member.MemberRepository;
import miniproject01.repository.member.MemoryMemberRepository;
import miniproject01.common.validator.BookValidator;
import miniproject01.common.validator.MemberValidator;
import miniproject01.service.library.LibraryService;
import miniproject01.service.library.LibraryServiceImpl;

import java.util.Scanner;

public class Library {

    private MemberRepository memberRepository;
    private BookRepository bookRepository;
    private LibraryService libraryService;

    public Library() {
        memberRepository = new MemoryMemberRepository();
        bookRepository = new MemoryBookRepository();
//        bookRepository = new DataBookRepository();
//        libraryService = new LibraryServiceImpl();
    }

    /**
     * 회원 추가
     * @param scanner
     * 이름이 Null 값일 경우 오류 발생
     * 전화번호가 Null 값이거나 13자리가 아닐 경우 오류 발생
     * 생년월일이 Null 값이거나 '-' 제외 6자리가 아닐 경우 오류 발생
     */
    public void addMember(Scanner scanner) {

        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("전화번호를 입력하세요('-' 포함): ");
        String phoneNumber = scanner.nextLine();

        System.out.print("생년월일을 입력하세요(6자리, '-' 제외): ");
        String birth = scanner.nextLine();

        try {
            Member member = new Member(name, phoneNumber, birth);
            MemberValidator.isValidMember(member);
            memberRepository.save(member);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 도서 추가
     * @param scanner
     * 제목, 저자 Null 값일 경우 오류 발생
     */
    public void addBook(Scanner scanner) {

        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();

        System.out.print("저자를 입력하세요: ");
        String author = scanner.nextLine();

        try {
            Book book = new Book(title, author);
            BookValidator.isValidBook(book);
            bookRepository.save(book);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 회원 목록 조회
     * 회원 목록이 비었을 경우 안내 문구
     */
    public void listAllMembers() {
        if (emptyMemberRepository()) return;

        memberRepository.findAll();
    }

    /**
     * 도서 목록 조회
     * 도서 목록이 비었을 경우 안내 문구
     */
    public void listAllBooks() {
        if (emptyBookRepository()) return;

        bookRepository.findAll();
    }

    /**
     * 회원 검색
     * @param scanner
     * 입력한 이름 Null 값일 경우 오류 발생
     * 해당 이름의 회원이 존재하지 않을 경우 안내 문구
     */
    public void searchMember(Scanner scanner) {
        if (emptyMemberRepository()) return;

        System.out.print("검색할 이름을 입력하세요: ");
        String searchName = scanner.nextLine();

        try {
            MemberValidator.searchValid(memberRepository, searchName);
            memberRepository.findByName(searchName);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 도서 검색
     * @param scanner
     * 입력한 제목 Null 값일 경우 오류 발생
     * 해당 제목의 도서가 존재하지 않을 경우 안내 문구
     */
    public void searchBook(Scanner scanner) {
        if (emptyBookRepository()) return;

        System.out.print("검색할 도서 제목을 입력하세요: ");
        String searchTitle = scanner.nextLine();

        try {
            BookValidator.searchValid(bookRepository, searchTitle);
            bookRepository.findByTitle(searchTitle);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 도서 대여
     * @param scanner
     * 등록되지 않은 도서, 회원일 경우 오류 발생
     * 이미 대여 중인 도서인 경우 안내 문구
     */
    public void rentBook(Scanner scanner) {
        if (emptyMemberRepository()) return;
        if (emptyBookRepository()) return;

        System.out.print("대여할 도서 ID를 입력하세요: ");
        Long bookID = scanner.nextLong();

        System.out.print("대여할 회원 ID를 입력하세요: ");
        Long memberID = scanner.nextLong();

        Book book = bookRepository.findById(bookID);
        Member member = memberRepository.findById(memberID);

//        libraryService.rentBook(book, member);
    }

    /**
     * 도서 반납
     * @param scanner
     * 등록되지 않은 도서일 경우 오류 발생
     * 대여 중인 도서가 아닐 경우 안내 문구
     */
    public void returnBook(Scanner scanner) {
        if (emptyRentedBook()) return;

        System.out.print("반납할 도서 ID를 입력하세요: ");
        Long bookID = scanner.nextLong();

        Book book = bookRepository.findById(bookID);

//        libraryService.returnBook(book);
    }

    /**
     * 대여 중인 도서 목록
     */
    public void listRentBooks() {
        if (emptyRentedBook()) return;

        libraryService.listRentedBooks();
    }

    /**
     * 대여 중인 도서 목록이 비었는지 여부 반환
     * @return
     */
    public boolean clearRentBook() {
//        return libraryService.rentedBookEmpty();
        return false;
    }

    private boolean emptyMemberRepository() {
        if (memberRepository.isEmpty()) {
            System.out.println("등록된 회원 정보가 없습니다.");
            return true;
        }
        return false;
    }

    private boolean emptyBookRepository() {
        if (bookRepository.isEmpty()) {
            System.out.println("등록된 도서가 없습니다.");
            return true;
        }
        return false;
    }

    private boolean emptyRentedBook() {
//        if (libraryService.rentedBookEmpty()) {
//            System.out.println("대여 중인 도서가 없습니다.");
//            return true;
//        }
        return false;
    }
}
