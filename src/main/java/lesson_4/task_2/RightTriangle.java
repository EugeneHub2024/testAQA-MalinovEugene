package lesson_4.task_2;

class RightTriangle extends SuperFigure{
    private double legA;
    private double legB;
    private double hypotenuse;

    public RightTriangle(double legA, double legB, String backgroundColor, String borderColor) {
        super(backgroundColor, borderColor, "Прямоугольный треугольник");
        this.legA = legA;
        this.legB = legB;
        this.hypotenuse = Math.sqrt(legA * legA + legB * legB);
    }

    @Override
    public double getArea() {
        return 0.5 * legA * legB;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + hypotenuse;
    }
}
