package interface_homework.question04;

import java.util.Scanner;

/**
 * main에서 ReadWritable 타입으로 FileHandler 객체를 다루며 readContent(), writeContent() 호출
 */
public class FileMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("파일에 입력할 내용을 입력하세요: ");
        String content = sc.nextLine();

        ReadWritable file = new FileHandler();

        file.writeContent(content);
        file.readContent();
    }
}
