package stream_homework_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 주어진 제품 리스트에서 각 카테고리별로 평균 가격을 계산하시오.
 */
public class Question_05 {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)
                ))
                .forEach((category, price) ->
                        System.out.println(category + ": " + price));
    }
}

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}