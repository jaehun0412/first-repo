package string_homework.question01;

import java.util.Scanner;

/**
 * 문자열 숫자합 구하기
 * <p>
 * 요구사항:
 * 문자열 내에 포함된 숫자(0~9)들을 모두 찾아 그 합을 구하여 반환하는 메소드를 작성하세요.
 * <p>
 * 메소드명: sumOfDigits(String str)
 * 반환타입: int
 * <p>
 * 예시:
 * sumOfDigits("abc123") -> 6  (1+2+3 = 6)
 * sumOfDigits("a1b2c3d9") -> 15 (1+2+3+9 = 15)
 * <p>
 * 힌트:
 * Character.isDigit() 메서드로 숫자 판별
 * 문자를 숫자로 변환할 때는 Character.getNumericValue() 활용
 */
public class Question01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자의 합을 구할 문자열을 입력하세요: ");
        String input = sc.nextLine();

        int result = sumOfDigits(input);
        System.out.println("입력한 문자열에서 숫자의 합은 " + result + "입니다.");
    }

    static int sumOfDigits(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sum += Character.getNumericValue(charAt);
            }
        }
        return sum;
    }
}
