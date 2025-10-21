package abstract_homework.question03;

import java.util.Scanner;

/**
 * main 메서드에서 두 변환기를 이용하여 원본 문자열 "Hello Java"를 변환하고, print()를 통해 결과를 출력해보자.
 */
public class ConverterMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("변환할 문자를 입력하세요: ");
        String content = sc.nextLine();

        DocumentConverter htmlConverter = new HtmlConverter();
        DocumentConverter markdownConverter = new MarkdownConverter();

        String htmlConverted = htmlConverter.convert(content);
        htmlConverter.print(htmlConverted);

        String markdownConverted = markdownConverter.convert(content);
        markdownConverter.print(markdownConverted);

    }
}
