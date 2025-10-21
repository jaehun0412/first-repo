package hw1.step4.question08;

import java.util.Scanner;

public class Question08 {

    public static void main(String[] args) {
        /*
        학생 5명의 점수를 입력받아 배열에 저장
        1. 전체 평균 점수
        2. 최고 점수
        3. 60점 이상인 학생의 수
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("학생 5명의 점수를 입력하세요: ");
        int student1 = sc.nextInt();
        int student2 = sc.nextInt();
        int student3 = sc.nextInt();
        int student4 = sc.nextInt();
        int student5 = sc.nextInt();
        int[] scores = {student1, student2, student3, student4, student5};

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double avg = (double) sum / scores.length;
        System.out.println("전체 평균 점수는 " + avg + "점 입니다.");

        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        System.out.println("최고 점수는 " + max + "점 입니다.");

        int count = 0;
        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }
        System.out.println("60점 이상인 학생의 수는 " + count + "명 입니다.");
    }
}
