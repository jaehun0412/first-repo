package abstract_homework.question02;

/**
 * Shape를 상속받는 클래스 Rectangle(사각형)과 Circle(원)을 만든다.
 * Rectangle은 width, height 필드를 갖고, 생성자를 통해 초기화
 * getArea(): width * height
 * getPerimeter(): 2 * (width + height)
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle - ";
    }
}
