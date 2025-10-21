package interface_homework.question03;

import java.util.Scanner;

/**
 * main 메서드에서 Calculator 타입으로 BasicCalculator와 AdvancedCalculator를 각각 사용해보고,
 * AdvancedCalculator를 Multipliable 타입으로 사용해 multiply도 호출해본다.
 */
public class CalculatorMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("연산을 원하는 두 숫자를 입력하세요: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        Calculator basicCalculator = new BasicCalculator();
        Calculator advancedCalculator = new AdvancedCalculator();

        System.out.println("Calculator - BasicCalculator");
        System.out.println("basicCalculator.add(a, b) = " + basicCalculator.add(a, b));
        System.out.println("basicCalculator.subtract(a, b) = " + basicCalculator.subtract(a, b));

        System.out.println("\nCalculator - AdvancedCalculator");
        System.out.println("advancedCalculator.add(a, b) = " + advancedCalculator.add(a, b));
        System.out.println("advancedCalculator.subtract(a, b) = " + advancedCalculator.subtract(a, b));

        System.out.println("\nMultipliable - AdvancedCalculator");
        Multipliable calculator = new AdvancedCalculator();
        System.out.println("calculator.multiply(a, b) = " + calculator.multiply(a, b));
    }
}
