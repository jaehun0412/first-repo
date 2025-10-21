package stream_homework_01;

import java.util.Arrays;

/**
 * 주어진 정수 배열에서 짝수만을 찾아 그 합을 구하시오.
 */
public class Question_01 {

    public static void main(String[] args) {
        int[] numbers = {3, 10, 4, 17, 6};

        int sum = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);

        System.out.println("짝수의 합: " + sum);
    }
}
