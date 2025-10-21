package hw1.step2.question03;

public class Question03 {

    public static void main(String[] args) {
        // 3. 1부터 100까지의 합을 구하는 프로그램을 작성하세요.
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1부터 100까지의 합은 " + sum + "입니다.");
    }
}
