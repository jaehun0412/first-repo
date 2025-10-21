package string_homework.question06;

import java.util.Scanner;

/**
 * 문자열 역순 변환하기
 * <p>
 * 요구사항
 * 메소드명: reverseChange(String str)
 * 반환타입: String
 * 주어진 문자열을 역순으로 뒤집어 반환한다.
 * <p>
 * 예시
 * reverseChange("abc") -> "cba"
 * reverseChange("Hello") -> "olleH"
 * <p>
 * 힌트
 * 문자열을 끝에서부터 시작하여 새로운 문자열에 추가
 * 또는 StringBuilder의 reverse() 메서드 활용
 */
public class Question06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String content = sc.nextLine();

        String result = reverseChange(content);
        System.out.println("입력한 문자열의 역순은 " + result + "입니다.");
    }

    static String reverseChange(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
