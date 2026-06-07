package lesson_4.task_2;

class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7.0, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Синий", "Желтый");
        RightTriangle triangle = new RightTriangle(3.0, 4.0, "Зеленый", "Белый");

        System.out.println("Задание 2");

        circle.info();
        rectangle.info();
        triangle.info();
    }
}
