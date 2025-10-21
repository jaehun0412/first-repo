package stream_homework_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 직원 객체의 리스트에서 각 부서(department)별로 평균 급여를 계산하시오.
 */
public class Question_04 {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .forEach((dep, sal) -> System.out.println(dep + ": " + sal));
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}