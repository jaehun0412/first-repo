package stream_homework_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 학생 리스트에서 나이대별(10대, 20대 등)로 평균 점수를 계산하시오.
 */
public class Question_06 {

    public static void main(String[] args) {
        List<Student06> students = Arrays.asList(
                new Student06("Alice", 14, 88),
                new Student06("Bob", 23, 82),
                new Student06("Charlie", 17, 95),
                new Student06("David", 21, 73)
        );

        students.stream()
                .collect(Collectors.groupingBy(
                        age -> age.getAge() / 10,
                        Collectors.averagingDouble(Student06::getScore)
                ))
                .forEach((age, score) ->
                        System.out.println(age * 10 + "s: " + score));
    }
}

class Student06 {
    private String name;
    private int age;
    private int score;

    public Student06(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}