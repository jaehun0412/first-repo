package hw1.step4.question10;

import java.util.Arrays;
import java.util.Random;

public class Question10 {

    public static void main(String[] args) {
        /*
        로또 번호 생성기
        1 ~ 45 사이의 숫자를 중복되지 않게 6개를 랜덤으로 뽑아 배열에 저장
        오름차순으로 정렬하여 출력
         */

        Random random = new Random();
        int[] numbers = new int[6];
        int index = 0;
        boolean isSame;

        while (index < numbers.length) {
            isSame = false;

            int randomNum = random.nextInt(45) + 1;

            for (int i = 0; i < index; i++) {
                if (numbers[i] == randomNum) {
                    isSame = true;
                    break;
                }
            }

            if (!isSame) {
                numbers[index++] = randomNum;
            }
        }

        Arrays.sort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));
    }
}