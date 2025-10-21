package stream_homework_02;

import java.util.Arrays;
import java.util.List;

/**
 * 주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라.
 * 스트림의 filter()와 findFirst() 메서드를 활용하라.
 */
public class Question_04 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "dog", "elephant", "bird", "giraffe");

        words.stream()
                .filter(word -> word.length() >= 5)
                .findFirst()
                .ifPresent(word -> System.out.println("조건에 맞는 첫 번째 단어: " + word));
    }
}
