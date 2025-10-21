package hw1.step3.question06;

import java.util.Scanner;

public class Question06 {

    public static void main(String[] args) {
        // 6. 정수 5개를 입력받아 배열에 저장한 후, 최대값과 최소값을 출력하세요.
        Scanner sc = new Scanner(System.in);

        System.out.print("5개의 정수를 입력하세요: ");
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int input3 = sc.nextInt();
        int input4 = sc.nextInt();
        int input5 = sc.nextInt();
        int[] arr = {input1, input2, input3, input4, input5};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("5개의 정수 중 최대값은 " + max + ", 최소값은 " + min + "입니다.");
    }
}
