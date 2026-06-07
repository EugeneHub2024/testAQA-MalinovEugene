package lesson_4.task_2;

class Rectangle extends SuperFigure{
    private double width;
    private double height;

    public Rectangle(double width, double height, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor, "Прямоугольник");
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
