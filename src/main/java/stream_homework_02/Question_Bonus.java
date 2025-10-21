package stream_homework_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 주어진 List<String>에서 길이가 4 이상인 문자열만 필터링하고,
 * 대문자로 변환한 후, 알파벳 순으로 정렬하여 출력하라.
 */
public class Question_Bonus {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "kiwi", "banana", "fig", "grape", "mango");

        List<String> list = fruits.stream()
                .filter(word -> word.length() >= 4)
                .map(String::toUpperCase)
                .sorted(Comparator.comparing(String::toString))
                .toList();

        System.out.println(list);
    }
}
