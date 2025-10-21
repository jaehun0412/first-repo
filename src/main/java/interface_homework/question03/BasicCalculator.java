package interface_homework.question03;

/**
 * Calculator를 구현하는 BasicCalculator 클래스를 만든다.
 * 단순히 +, - 연산 결과를 반환
 */
public class BasicCalculator implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
