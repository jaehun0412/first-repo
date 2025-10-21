package stream_homework_02;

import java.util.Arrays;
import java.util.List;

/**
 * 주어진 List<Integer>의 모든 요소가 짝수인지 확인하라.
 * 스트림의 allMatch() 메서드와 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
 */
public class Question_06 {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> numbers2 = Arrays.asList(2, 4, 5, 8, 10);

        boolean allEven1 = numbers1.stream()
                .allMatch(n -> n % 2 == 0);

        boolean allEven2 = numbers2.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println("numbers1 모두 짝수인가? " + allEven1);
        System.out.println("numbers2 모두 짝수인가? " + allEven2);
    }
}
