package lesson_4.task_2;

interface Figure {
    double getArea();
    double getPerimeter();

    String getFigureName();
    String getBackgroundColor();
    String getBorderColor();

    default void info() {
        System.out.println("Фигура: " + getFigureName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getBackgroundColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}

