package abstract_homework.question05;

/**
 * Transport를 상속받는 Bus와 Airplane 클래스를 만든다.
 * Airplane의 move() 메서드: "비행기가 하늘을 날아 이동합니다." 출력
 */
public class Airplane extends Transport {

    public Airplane(int capacity) {
        super(capacity);
    }

    @Override
    public void move() {
        System.out.println("비행기가 하늘을 날아 이동합니다.");
    }
}
