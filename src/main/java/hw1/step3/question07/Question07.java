package hw1.step3.question07;

import java.util.Scanner;

public class Question07 {

    public static void main(String[] args) {
        // 7. 문자열 배열에 "사과", "바나나", "딸기", "포도"를 저장하고,
        // 사용자로부터 과일 이름을 입력받아 배열 안에 존재하는지 찾는 프로그램을 작성하세요.
        Scanner sc = new Scanner(System.in);

        String[] fruits = {"사과", "바나나", "딸기", "포도"};
        System.out.print("배열에서 찾고 싶은 과일을 입력하세요: ");
        String input = sc.nextLine();
        String result = null;

        for (String fruit : fruits) {
            if (fruit.equals(input)) {
                result = input + "은 배열 안에 존재합니다.";
                break;
            }
            result = input + "은 배열 안에 존재하지 않습니다.";
        }
        System.out.println(result);
    }
}
