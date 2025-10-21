package stream_homework_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 여러 도시의 일일 최고 온도가 주어졌을 때, 각 도시의 최고 온도를 찾으시오.
 */
public class Question_07 {

    public static void main(String[] args) {
        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );

        temperatures.stream()
                .collect(Collectors.groupingBy(
                        Temperature::getCity,
                        Collectors.maxBy(Comparator.comparingInt(Temperature::getMaxTemp))
                        ))
                .forEach((city, temp) ->
                        System.out.println(city + ": " + temp.get().getMaxTemp()));
    }
}

class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}