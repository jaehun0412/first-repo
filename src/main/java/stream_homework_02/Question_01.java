package stream_homework_02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 주어진 List<String>을 문자열 길이에 따라 오름차순으로 정렬하되,
 * 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
 */
public class Question_01 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape", "strawberry");

        Collections.sort(words, (s1, s2) ->
                Comparator.comparingInt(String::length).compare(s1, s2));
        System.out.println(words);
    }
}
