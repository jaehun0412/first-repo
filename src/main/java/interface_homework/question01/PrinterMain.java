package interface_homework.question01;

import java.util.Scanner;

/**
 * main 메서드에서 Printer 타입 변수에 ConsolePrinter 객체를 할당하고, print 메서드를 호출해 메시지를 화면에 출력해보자.
 */
public class PrinterMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("출력을 원하는 메시지를 입력하세요: ");
        String message = sc.nextLine();

        Printer printer = new ConsolePrinter();
        printer.print(message);
    }
}
