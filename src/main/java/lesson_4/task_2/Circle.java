package lesson_4.task_2;

class Circle extends SuperFigure{
    private double radius;

    public Circle(double radius, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor, "Круг");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }
}
