package string_homework.question03;

import java.util.Scanner;

/**
 * 특정 문자 등장 횟수 세기
 * <p>
 * 요구사항:
 * 문자열과 특정 문자를 입력받아, 해당 문자가 문자열 내에 몇 번 등장하는지 세어 반환하는 메소드를 작성하세요.
 * <p>
 * 메소드명: countChar(String str, char c)
 * 반환타입: int
 * <p>
 * 예시:
 * countChar("banana", 'a') -> 3
 * countChar("hello", 'l') -> 2
 * <p>
 * 힌트:
 * 단순히 루프를 돌며 charAt()으로 문자를 비교하고 카운트 증가.
 */
public class Question03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String content = sc.nextLine();

        System.out.print("찾을 문자열을 입력하세요: ");
        char c = sc.nextLine().charAt(0);

        int result = countChar(content, c);
        System.out.println("입력한 문자열 '" + content + "'에서 찾을 문자열 '" + c + "'는 " + result + "번 등장합니다.");
    }

    static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
