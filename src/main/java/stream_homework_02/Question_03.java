package stream_homework_02;

import java.util.Arrays;
import java.util.List;

/**
 * 주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라.
 * 스트림의 map() 메서드와 람다식을 활용하라.
 */
public class Question_03 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> list = numbers.stream()
                .map(n -> n + 10)
                .toList();

        System.out.println("원본 리스트: " + numbers);
        System.out.println("변환된 리스트: " + list);
    }
}
