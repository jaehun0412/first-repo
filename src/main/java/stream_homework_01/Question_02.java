package stream_homework_01;

import java.util.Arrays;
import java.util.List;

/**
 * 주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 선택하여 대문자로 변환하고, 결과를 리스트로 반환하시오.
 */
public class Question_02 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> filteredWords = words.stream()
                .filter(word -> word.length() >= 5)
                .map(String::toUpperCase)
                .toList();

        System.out.println(filteredWords);
    }
}
