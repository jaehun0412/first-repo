package abstract_homework.question02;

/**
 *Shape를 상속받는 클래스 Rectangle(사각형)과 Circle(원)을 만든다.
 * Circle은 radius 필드를 갖고, 생성자를 통해 초기화
 * getArea(): Math.PI * radius * radius
 * getPerimeter(): 2 * Math.PI * radius
 */
public class Circle extends Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle - ";
    }
}
