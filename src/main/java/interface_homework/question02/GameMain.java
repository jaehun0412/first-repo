package interface_homework.question02;

import java.util.Scanner;

/**
 * main 메서드에서 GameObject 객체를 만들고, move와 draw를 호출해 동작을 확인한다.
 */
public class GameMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("캐릭터 생성을 원하는 좌표를 입력하세요(x, y): ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        GameObject obj = new GameObject();
        obj.move(x, y);
        obj.draw();
    }
}
