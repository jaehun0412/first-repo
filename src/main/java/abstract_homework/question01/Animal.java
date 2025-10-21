package abstract_homework.question01;

/**
 * 추상 클래스 Animal을 작성한다.
 * 필드: String name (동물의 이름)
 * 생성자: Animal(String name)
 * 추상 메서드: void makeSound() (동물의 소리를 출력)
 * 일반 메서드: void eat() (예: "동물이 먹이를 먹습니다." 라고 출력)
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void eat() {
        System.out.println("동물이 먹이를 먹습니다.");
    }
}
