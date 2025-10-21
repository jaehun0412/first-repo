package abstract_homework.question03;

/**
 * 추상 클래스 DocumentConverter를 만든다.
 * 추상 메서드: String convert(String content) (문서 내용을 다른 형식으로 변환)
 * 일반 메서드: void print(String content) (변환된 내용을 출력)
 */
public abstract class DocumentConverter {

    public abstract String convert(String content);

    public void print(String content) {
        System.out.println(content);
    }
}
