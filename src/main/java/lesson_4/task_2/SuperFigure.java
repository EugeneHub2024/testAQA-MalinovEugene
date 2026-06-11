package lesson_4.task_2;

abstract class SuperFigure implements Figure {
    private String backgroundColor;
    private String borderColor;
    private String name;

    public SuperFigure(String backgroundColor, String borderColor, String name) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.name = name;
    }

    @Override
    public String getFigureName() { return name; }

    @Override
    public String getBackgroundColor() { return backgroundColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}
