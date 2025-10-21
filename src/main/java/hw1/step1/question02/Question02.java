package hw1.step1.question02;

import java.util.Scanner;

public class Question02 {

    public static void main(String[] args) {
        // 2. 세 개의 정수를 입력받아 그 중 가장 큰 수를 출력하세요.
        Scanner sc = new Scanner(System.in);

        System.out.print("세 개의 정수를 입력하세요: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        System.out.println("세 개의 정수 중 가장 큰 숫자는 " + max + "입니다.");
    }
}
