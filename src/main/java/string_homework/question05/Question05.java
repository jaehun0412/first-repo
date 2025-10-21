package string_homework.question05;

import java.util.Scanner;

/**
 * 문자열 내 공백 및 알파벳 개수 세기
 * <p>
 * 요구사항
 * 메소드1: spaceCount(String str)
 * 문자열 내에 포함된 공백 문자(' ')의 개수를 반환한다.
 * 메소드2: alphaCount(String str)
 * 문자열 내에 포함된 알파벳(대소문자 포함) 문자의 개수를 반환한다.
 * <p>
 * 예시
 * spaceCount("test tset ts ttt") -> 3
 * alphaCount("test tset ts ttt") -> 13
 * <p>
 * 힌트
 * 문자 하나씩 확인하는 for 루프 혹은 for-each 루프 활용
 * Character.isWhitespace()로 공백체크, Character.isLetter()로 알파벳 체크
 */
public class Question05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String content = sc.nextLine();

        int spaceCount = spaceCount(content);
        int alphaCount = alphaCount(content);

        System.out.println("입력한 문자열의 공백 개수는 " + spaceCount + "개 입니다.");
        System.out.println("입력한 문자열의 알파벳 개수는 " + alphaCount + "개 입니다.");
    }

    static int spaceCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isWhitespace(charAt)) {
                count++;
            }
        }
        return count;
    }

    static int alphaCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isLetter(charAt)) {
                count++;
            }
        }
        return count;
    }
}
