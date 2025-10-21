package abstract_homework.question05;

/**
 * main 메서드에서 Transport 타입 배열에 Bus와 Airplane 객체를 담은 후, 반복문을 통해 move()와 showCapacity()를 호출한다.
 */
public class TransportMain {

    public static void main(String[] args) {
        Transport[] transports = new Transport[2];

        transports[0] = new Bus(40);
        transports[1] = new Airplane(300);

        for (Transport transport : transports) {
            transport.move();
            transport.showCapacity();
        }
    }
}
