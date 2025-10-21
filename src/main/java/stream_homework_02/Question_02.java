package stream_homework_02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

/**
 * 주어진 정수 배열에서 최대값을 찾아 출력하라.
 * 람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.stream()과 max() 메서드를 활용하라.
 */
public class Question_02 {

    public static void main(String[] args) {
        int[] numbers = {23, 45, 12, 67, 34, 89, 56};

        int maxValue = Arrays.stream(numbers).max()
                .getAsInt();
        System.out.println("최대값: " + maxValue);
    }
}
