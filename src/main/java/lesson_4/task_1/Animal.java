package lesson_4.task_1;

public class Animal {
    protected String view;
    protected String name;

    protected static int animalCount = 0;
    protected static int catCount = 0;
    protected static int dogCount = 0;

    public Animal(String view, String name) {
        this.view = view;
        this.name = name;

        animalCount++;

        if (view.equals("Кот")) {
            catCount++;
        } else if (view.equals("Пес")) {
            dogCount++;
        }
    }

    public void run(int distance) {
        if (view.equals("Кот") && distance <= 200 || view.equals("Пес") && distance <= 500) {
            System.out.println(view + " " + name + " " + "пробежал " + distance + " м");
        } else {
            System.out.println(view + " " + name + " " + "не может пробежать " + distance + " м");
        }
    };

    public  void swim(int distance) {
        if(view.equals("Пес") && distance <= 10) {
            System.out.println(view + " " + name + " " + "проплыл " + distance + " м");
        } else if (view.equals("Кот")) {
            System.out.println(view + " " + name + " " + "не умеет плавать");
        } else {
            System.out.println(view + " " + name + " " + "не может проплыть " + distance + " м");
        }
    };

    public static void getAnimalCount() {
        System.out.println();
        System.out.println("Количество животных: " + animalCount);
        System.out.println("Количество котов: " + catCount);
        System.out.println("Количество псов: " + dogCount);
    };
}
