package abstract_homework.question03;

/**
 * DocumentConverter를 상속받는 클래스 HtmlConverter, MarkdownConverter를 만든다.
 * HtmlConverter의 convert() 메서드는 원본 문자열을 HTML 형식의 <p>...</p>로 감싸서 반환
 * 예: "Hello" -> "
 * Hello
 * "
 */
public class HtmlConverter extends DocumentConverter {

    @Override
    public String convert(String content) {
        return "<p>" + content + "</p>";
    }
}
