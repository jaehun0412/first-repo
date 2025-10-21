package string_homework.question04;

import java.util.Scanner;

/**
 * 물품번호 검증 메소드 작성하기
 * <p>
 * 요구사항
 * 메소드명: checkProductNumber(String productNumber)
 * 반환타입: boolean
 * 조건:
 * 1. 물품번호의 길이는 6자리여야 한다.
 * 2. 물품번호의 1, 2번째 문자는 알파벳(대소문자 상관없음)이어야 한다.
 * 3. 물품번호의 3~6번째 문자는 모두 숫자여야 한다.
 * <p>
 * 예시
 * checkProductNumber("te3456") -> true
 * checkProductNumber("t33456") -> false (두 번째 문자가 숫자이므로)
 * checkProductNumber("ar49786") -> false (길이가 7이므로)
 * checkProductNumber("test56") -> false (길이가 6이지만 3~6번째에 알파벳 's' 포함)
 * <p>
 * 힌트
 * String.length()로 길이 체크
 * charAt() 메서드로 특정 문자 추출
 * Character.isLetter()와 Character.isDigit() 메서드 활용
 */
public class Question04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("물품번호를 입력하세요: ");
        String productNumber = sc.nextLine();

        boolean result = checkProductNumber(productNumber);
        System.out.println(result ? "입력한 물품 번호는 " + productNumber + "입니다." : "");
    }

    static boolean checkProductNumber(String productNumber) {
        if (productNumber.length() != 6) {
            System.out.println("물품번호의 길이는 6자리여야 합니다.");
            return false;
        }

        for (int i = 0; i <= 1; i++) {
            char charAt = productNumber.charAt(i);
            if (Character.isDigit(charAt)) {
                System.out.println("물품번호의 1, 2번째 문자는 알파벳(대소문자 상관없음)이어야 합니다.");
                return false;
            }
        }

        for (int i = 2; i < productNumber.length(); i++) {
            char charAt = productNumber.charAt(i);
            if (Character.isLetter(charAt)) {
                System.out.println("물품번호의 3~6번째 문자는 모두 숫자여야 합니다.");
                return false;
            }
        }

        return true;
    }
}
