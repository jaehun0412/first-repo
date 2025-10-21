package interface_homework.question02;

/**
 * GameObject 클래스를 만들고, Movable, Drawable를 동시에 구현한다.
 * int x, y 필드를 갖는다.
 * move(int x, int y) 메서드 구현 시: x,y 좌표를 갱신
 * draw() 메서드 구현 시: 현재 좌표를 "객체가 (x,y)에 그려졌습니다." 형태로 출력
 */
public class GameObject implements Movable, Drawable {

    private int x;
    private int y;

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println("객체가 (" + x + "," + y + ")에 그려졌습니다.");
    }
}
