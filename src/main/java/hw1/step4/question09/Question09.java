package hw1.step4.question09;

import java.util.Random;
import java.util.Scanner;

public class Question09 {

    public static void main(String[] args) {
        /*
        1 ~ 100 사이의 랜덤 숫자 하나 정하기
        사용자가 숫자를 입력
        - 정답보다 클 경우 "더 작은 수를 입력하세요."
        - 정답보다 작으면 "더 큰 수를 입력하세요."
        - 정답을 맞히면 "정답입니다!"를 출력하고 종료
         */

        Scanner sc = new Scanner(System.in);
        int randomNum = new Random().nextInt(100) + 1;

        System.out.print("1 ~ 100 사이의 숫자를 입력하세요: ");
        while (true) {

            int input = sc.nextInt();

            if (input < 0 || input > 100) {
                System.out.print("숫자는 1 ~ 100 사이로만 입력해야 합니다: ");
                continue;
            }

            if (input > randomNum) {
                System.out.print("더 작은 수를 입력하세요: ");
                continue;
            }

            if (input < randomNum) {
                System.out.print("더 큰 수를 입력하세요: ");
                continue;
            }

            if (input == randomNum) {
                System.out.println("정답입니다!");
                break;
            }
        }


    }
}
