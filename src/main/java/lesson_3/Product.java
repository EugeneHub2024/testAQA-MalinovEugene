package lesson_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private String name;
    private LocalDate date;
    private String manufacturer;
    private  String country;
    private double price;
    private boolean status;

    public Product(String name, LocalDate date, String manufacturer, String country, double price, boolean status) {
        this.name = name;
        this.date = date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.status = status;
    }

    public void info() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formatDate = date.format(formatter);

        System.out.println("Наименование товара: " + name + "\n" + "Дата производства: " + formatDate + "\n" + "Компания производитель: " + manufacturer + "\n" + "Страна производства: " + country + "\n" + "Цена товара: " + price + "\n" + "Статус бронирования: " + status + "\n");
    }

    public static void main(String[] args) {
        Product product = new Product("OnePlus 15", LocalDate.of(2025, 12, 15), "BBK Electronics", "China", 75000, false);

        System.out.println("Задание 1");
        product.info();
        System.out.println("Задание 2");

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", LocalDate.of(2025, 2, 11), "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S25+", LocalDate.of(2025, 2, 12), "Samsung Corp.", "Korea", 5500, true);
        productsArray[2] = new Product("Samsung S25", LocalDate.of(2025, 2, 13), "Samsung Corp.", "Korea", 5200, true);
        productsArray[3] = new Product("Samsung S25 Edge", LocalDate.of(2025, 2, 14), "Samsung Corp.", "Korea", 5000, true);
        productsArray[4] = new Product("Samsung S25 FE", LocalDate.of(2025, 2, 15), "Samsung Corp.", "Korea", 4800, true);

        for (Product object : productsArray) {
            object.info();
        }
    }
}
