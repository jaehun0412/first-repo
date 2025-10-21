package abstract_homework.question05;

/**
 * 추상 클래스 Transport를 만든다.
 * 필드: int capacity (수용 인원)
 * 생성자: Transport(int capacity)
 * 추상 메서드: void move() (이동 동작 출력)
 * 일반 메서드: void showCapacity() ("최대 X명까지 탑승 가능합니다." 출력)
 */
public abstract class Transport {

    private int capacity;

    public Transport(int capacity) {
        this.capacity = capacity;
    }

    public abstract void move();

    public void showCapacity() {
        System.out.println("최대 " + capacity + "명까지 탑승 가능합니다.");
    }
}
