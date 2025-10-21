package miniproject01.controller;

public class MenuGenerator {

    public static void generateMenu() {
        System.out.println("\n======== 도서관 관리 프로그램 ========");
        System.out.println("1. 회원 추가\t2. 도서 추가");
        System.out.println("3. 회원 목록\t4. 도서 목록");
        System.out.println("5. 회원 검색\t6. 도서 검색");
        System.out.println("7. 도서 대여\t8. 도서 반납");
        System.out.println("9. 미반납 도서\t10. 프로그램 종료");
        System.out.println("======================================");
        System.out.print("원하는 메뉴를 선택하세요: ");
    }
}
