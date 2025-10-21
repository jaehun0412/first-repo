package abstract_homework.question02;

/**
 * main 메서드에서 Shape 배열을 만들고, Rectangle과 Circle 객체를 담은 뒤, 반복문을 통해 각 도형의 면적과 둘레를 출력한다.
 */
public class ShapeMain {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle(5, 4);
        shapes[1] = new Circle(3);

        for (Shape shape : shapes) {
            double area = shape.getArea();
            double perimeter = shape.getPerimeter();
            System.out.println(shape + "Area: " + area + ", Perimeter: " + perimeter);
        }
    }
}
