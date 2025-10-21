package miniproject01.controller;

import miniproject01.dto.Book;
import miniproject01.dto.Member;
import miniproject01.repository.book.JDBCBookRepository;
import miniproject01.repository.library.MemoryLibraryImpl;
import miniproject01.repository.member.JDBCMemberRepository;
import miniproject01.service.library.LibraryService;
import miniproject01.service.library.LibraryServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        LibraryService service = new LibraryServiceImpl(new MemoryBookRepository(), new MemoryMemberRepository(), new MemoryLibraryImpl());
        LibraryService service = new LibraryServiceImpl(new JDBCBookRepository(), new JDBCMemberRepository(), new MemoryLibraryImpl());
//        Library library = new Library();

        while (true) {
            menu();

            try {

                int menu = scanner.nextInt();
                scanner.nextLine();

                switch (menu) {
                    case 1:
                        // 회원 추가
                        System.out.println("\n'회원 추가' 선택하셨습니다.\n");

                        System.out.print("이름을 입력하세요: ");
                        String name = scanner.nextLine();

                        System.out.print("전화번호를 입력하세요('-' 포함): ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("생년월일을 입력하세요(6자리, '-' 제외): ");
                        String birth = scanner.nextLine();

                        Member member = new Member(name, phoneNumber, birth);
                        boolean addMember = service.addMember(member);

                        if (addMember) {
                            System.out.println("회원 등록에 성공했습니다.\n 등록된 회원 - " + member);
                        }
//                        library.addMember(scanner);
                        break;

                    case 2:
                        // 도서 추가
                        System.out.println("\n'도서 추가' 선택하셨습니다.\n");

                        System.out.print("제목을 입력하세요: ");
                        String title = scanner.nextLine();

                        System.out.print("저자를 입력하세요: ");
                        String author = scanner.nextLine();

                        Book book = new Book(title, author);
                        boolean addBook = service.addBook(book);

                        if (addBook) {
                            System.out.println("도서 등록에 성공했습니다.\n 등록된 도서 - " + book);
                        }
//                        library.addBook(scanner);
                        break;

                    case 3:
                        // 회원 목록
                        System.out.println("\n'회원 목록' 선택하셨습니다.\n");

                        System.out.println("등록된 회원 목록");
                        service.listAllMembers().forEach(members -> System.out.println(" - " + members));
//                        library.listAllMembers();
                        break;

                    case 4:
                        // 도서 목록
                        System.out.println("\n'도서 목록' 선택하셨습니다.\n");

                        System.out.println("등록된 도서 목록");
                        service.listAllBooks().forEach(books -> System.out.println(" - " + books));
//                        library.listAllBooks();
                        break;

                    case 5:
                        // 회원 검색
                        System.out.println("\n'회원 검색' 선택하셨습니다.\n");

                        System.out.print("검색할 이름을 입력하세요: ");
                        String searchName = scanner.nextLine();

                        List<Member> memberByName = service.findMemberByName(searchName);
                        memberByName.forEach(members -> System.out.println(" - " + members));
//                        library.searchMember(scanner);
                        break;

                    case 6:
                        // 도서 검색
                        System.out.println("\n'도서 검색' 선택하셨습니다.\n");

                        System.out.print("검색할 도서 제목을 입력하세요: ");
                        String searchTitle = scanner.nextLine();

                        List<Book> bookByTitle = service.findBookByTitle(searchTitle);
                        bookByTitle.forEach(books -> System.out.println(" - " + books));
//                        library.searchBook(scanner);
                        break;

                    case 7:
                        // 도서 대여
                        System.out.println("\n'도서 대여' 선택하셨습니다.\n");

                        System.out.print("대여할 도서 ID를 입력하세요: ");
                        Long rentBookId = scanner.nextLong();

                        System.out.print("대여할 회원 ID를 입력하세요: ");
                        Long memberID = scanner.nextLong();

                        boolean rentBook = service.rentBook(rentBookId, memberID);

                        if (rentBook) {
                            System.out.println("도서 대여가 완료되었습니다.");
                        }
//                        library.rentBook(scanner);
                        break;

                    case 8:
                        // 도서 반납
                        System.out.println("\n'도서 반납' 선택하셨습니다.\n");

                        System.out.print("반납할 도서 ID를 입력하세요: ");
                        Long returnBookID = scanner.nextLong();

                        boolean returnBook = service.returnBook(returnBookID);

                        if (returnBook) {
                            System.out.println("도서 반납이 완료되었습니다.");
                        }
//                        library.returnBook(scanner);
                        break;

                    case 9:
                        // 미반납 도서
                        System.out.println("\n'미반납 도서' 선택하셨습니다.\n");

                        System.out.println("대여 중인 도서 목록");
                        service.listRentedBooks().forEach(books -> System.out.println(" - " + books));
//                        library.listRentBooks();
                        break;

                    case 10:
                        // 종료
                        // 미반납 도서가 있을 경우 종료 여부 (or 메뉴선택 돌아가기)
                        /*library.clearRentBook()*/
                        if (!service.rentedBookEmpty()) {
                            System.out.println("미반납 도서가 있습니다.");
                            break;
                        }

                        System.out.println("\n프로그램을 종료합니다.\n");
                        return;

                    default:
                        System.out.println("메뉴는 1~10까지 선택할 수 있습니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴는 숫자만 입력할 수 있습니다.");
                scanner.nextLine();
            }
        }
    }

    private static void menu() {
        MenuGenerator.generateMenu();
    }
}
