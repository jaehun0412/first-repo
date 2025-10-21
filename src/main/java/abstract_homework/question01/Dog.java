package abstract_homework.question01;

/**
 * Animal을 상속받는 구체 클래스 Dog와 Cat을 만든다.
 * makeSound() 메서드를 각각 "멍멍"과 "야옹"을 출력하도록 구현
 */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}
