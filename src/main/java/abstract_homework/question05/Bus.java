package abstract_homework.question05;

/**
 * Transport를 상속받는 Bus와 Airplane 클래스를 만든다.
 * Bus의 move() 메서드: "버스가 도로를 따라 이동합니다." 출력
 */
public class Bus extends Transport {

    public Bus(int capacity) {
        super(capacity);
    }

    @Override
    public void move() {
        System.out.println("버스가 도로를 따라 이동합니다.");
    }
}
