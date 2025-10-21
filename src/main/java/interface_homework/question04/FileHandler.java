package interface_homework.question04;

/**
 * FileHandler 클래스를 만들어 ReadWritable 구현
 * readContent() 메서드: "파일에서 내용을 읽습니다." 반환
 * writeContent(String content) 메서드: "파일에 내용을 썼습니다." 출력
 */
public class FileHandler implements ReadWritable {

    @Override
    public String readContent() {
        return "파일에서 내용을 읽습니다.";
    }

    @Override
    public void writeContent(String content) {
        System.out.println("파일에 " + content + "을 썼습니다.");
    }
}
