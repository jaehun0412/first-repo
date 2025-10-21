package abstract_homework.question03;

/**
 * DocumentConverter를 상속받는 클래스 HtmlConverter, MarkdownConverter를 만든다.
 * MarkdownConverter의 convert() 메서드는 원본 문자열 앞뒤에 마크다운 문법의 ** 를 붙여 굵은 텍스트로 변환
 * 예: "Hello" -> "Hello"
 */
public class MarkdownConverter extends DocumentConverter {

    @Override
    public String convert(String content) {
        return "**" + content + "**";
    }
}
