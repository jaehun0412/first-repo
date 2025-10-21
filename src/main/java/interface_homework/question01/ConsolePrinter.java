package interface_homework.question01;

/**
 * Printer 인터페이스를 구현하는 ConsolePrinter 클래스를 만든다.
 * print(String message) 메서드에서 전달받은 메시지를 콘솔에 출력한다.
 */
public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
