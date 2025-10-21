package stream_homework_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 학생 객체의 리스트가 주어졌을 때, 성적(score)이 80점 이상인 학생들만을 선택하고, 이들의 이름을 알파벳 순으로 정렬하여 출력하시오.
 */
public class Question_03 {

    public static void main(String[] args) {
        List<Student03> students = Arrays.asList(
                new Student03("Alice", 82),
                new Student03("Bob", 90),
                new Student03("Charlie", 72),
                new Student03("David", 76)
        );

        students.stream()
                .filter(student -> student.getScore() >= 80)
                .sorted(Comparator.comparing(Student03::getName))
                .forEach(student -> System.out.println(student.getName()));
    }
}

class Student03 {
    private String name;
    private int score;

    public Student03(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
