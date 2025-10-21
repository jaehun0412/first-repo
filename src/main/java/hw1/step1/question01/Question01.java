package hw1.step1.question01;

import java.util.Scanner;

public class Question01 {

    public static void main(String[] args) {
        // 1. 사용자로부터 정수를 입력받아 짝수인지 홀수인지 판별하는 프로그램을 작성하세요.
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int input = sc.nextInt();

        String result = (input % 2 == 0) ? "짝수입니다." : "홀수입니다.";
        System.out.println("입력한 숫자 " + input + "은 " + result);
    }
}
