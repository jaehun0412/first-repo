package hw2.question01;

/**
 * 생성자 2개
 * - 모든 정보를 받는 생성자
 * - 이름과 학번만 받는 생성자 (나이는 18, GPA는 0.0으로 초기화)
 *
 * 정보 수정 메서드
 * - updateAge(int newAge): 나이 수정 (유효성 검사 포함)
 * - updateGpa(double newGpa): GPA 수정 (유효성 검사 포함)
 *
 * 비즈니스 메서드
 * - displayInfo(): 학생 정보를 출력
 * - isExcellent(): GPA가 3.5 이상이면 true 반환
 * - updateGpa(double newGpa): GPA 업데이트 (0.0~4.0 범위 검사)
 *
 * 유효성 검사 규칙
 * 나이: 15~100 사이
 * GPA: 0.0~4.0 사이
 * 범위를 벗어나면 기존 값 유지하고 경고 메시지 출력
 */
public class Student {

    private String name;
    private int id;
    private int age;
    private double gpa;

    // 모든 정보를 받는 생성자
    public Student(String name, int id, int age, double GPA) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gpa = GPA;
    }

    // 이름과 학번만 받는 생성자 (나이는 18, GPA는 0.0으로 초기화)
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        age = 18;
        gpa = 0.0;
    }

    // 나이 수정
    public void updateAge(int newAge) {
        if (newAge < 15 || newAge > 100) {
            System.out.println("잘못된 값입니다. 나이는 15~100 사이만 가능합니다.");
            return;
        }
            age = newAge;
    }

    // GPA 수정
    public void updateGpa(double newGpa) {
        if (newGpa < 0.0 || newGpa > 4.0) {
            System.out.println("잘못된 값입니다. GPA 값은 0.0~4.0 사이만 가능합니다.");
            return;
        }
            gpa = newGpa;
    }

    // 학생 정보 출력
    public void displayInfo() {
        System.out.printf("이름: %s, 학번: %d, 나이: %d, GPA: %.1f\n", name, id, age, gpa);
    }

    // GPA가 3.5 이상이면 true 반환
    public boolean isExcellent() {
        if (gpa >= 3.5) {
            return true;
        }
        return false;
    }

    // 이름이 private이므로 getter를 통해 값 획득
    public String getName() {
        return name;
    }
}
