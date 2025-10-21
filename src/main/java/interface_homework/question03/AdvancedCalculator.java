package interface_homework.question03;

/**
 * Multipliable을 구현하는 AdvancedCalculator 클래스를 만든다.
 * multiply 메서드 구현
 * 추가로 AdvancedCalculator는 Calculator도 구현해 add, subtract도 가능하게 한다.
 */
public class AdvancedCalculator implements Calculator, Multipliable {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
