package hw1.step2.question05;

import java.util.StringJoiner;

public class Question05 {

    public static void main(String[] args) {
        // 5. 1부터 50까지 수 중에서 3의 배수이면서 5의 배수인 수만 출력하세요.
        System.out.print("1부터 50까지의 수 중 3의 배수이면서 5의 배수인 수: ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sb.append(i).append(", ");
            }
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()));

        // StringJoiner 사용
        System.out.println("\n========== StringJoiner 사용 ==========");
        System.out.print("1부터 50까지의 수 중 3의 배수이면서 5의 배수인 수: ");
        StringJoiner sj = new StringJoiner(",");
        for (int i = 1; i <= 50; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sj.add(String.valueOf(i));
            }
        }
        System.out.println(sj.toString());
    }
}
