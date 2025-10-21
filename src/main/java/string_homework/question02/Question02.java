package string_homework.question02;

import java.util.Scanner;

/**
 * 특정 문자열 치환하기
 * <p>
 * 요구사항:
 * 주어진 문자열에서 특정 단어를 모두 다른 단어로 치환하는 메소드를 작성하세요.
 * <p>
 * 메소드명: replaceAllWords(String original, String target, String replacement)
 * 반환타입: String
 * <p>
 * 예시:
 * replaceAllWords("I like cat. Cat is cute.", "cat", "dog")
 * -> "I like dog. Cat is cute."
 * (주의: 대소문자 구분, 정확히 일치하는 단어만 치환)
 * <p>
 * 힌트:
 * String.replace() 또는 String.replaceAll() 메서드 사용 가능.
 * 대소문자를 구분하려면 직접 비교하거나 정규식을 활용.
 * 대소문자 구분 없이 처리하고 싶다면 toLowerCase() 등을 활용한 로직 설계 필요.
 */
public class Question02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문장을 입력하세요: ");
        String original = sc.nextLine();

        System.out.print("치환되기를 원하는 단어를 입력하세요: ");
        String target = sc.nextLine();

        System.out.print("치환할 단어를 입력하세요: ");
        String replacement = sc.nextLine();

        String result = replaceAllWords(original, target, replacement);
        System.out.println("입력한 문장은 '" + original + "' 입니다.");
        System.out.println("치환한 뒤 바뀐 문장은 '" + result + "' 입니다.");
    }

    static String replaceAllWords(String original, String target, String replacement) {
        return original.replaceAll(target, replacement);
    }
}
