package abstract_homework.question01;

/**
 * main 메서드에서 Animal 타입의 변수에 Dog와 Cat 객체를 할당하고, makeSound()와 eat() 메서드를 호출해보자.
 */
public class AnimalMain {

    public static void main(String[] args) {
        Animal dog = new Dog("Dog");
        Animal cat = new Cat("Cat");

        dog.makeSound();
        dog.eat();
        cat.makeSound();
        cat.eat();
    }
}
