package hw1.step2.question04;

public class Question04 {

    public static void main(String[] args) {
        // 4. 구구단을 출력하는 프로그램을 작성하세요. (2단~9단)
        System.out.println("구구단 출력 (2단 ~ 9단)");
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
