package lesson_4.task_1;

public class Cat extends Animal{
    protected boolean satiety;

    public Cat(String view, String name) {
        super(view, name);
        this.satiety = false;
     }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFoodAmount() == 0) {
            bowl.addFood(amount);
        }
        if (satiety == true) {
            System.out.println(view + " " + name + " уже сыт и отказывается от еды");
            return;
        }
        if (bowl.getFoodAmount() >= 20) {
            bowl.decreaseFood(20);
            satiety = true;
            System.out.println(view + " " + name + " успешно покушал");
        } else {
            System.out.println(view + " " + name + " не стал кушать, так как в миске недостаточно еды");
            bowl.addFood(amount);
            bowl.decreaseFood(20);
            satiety = true;
            System.out.println(view + " " + name + " успешно покушал");
        }
    }
}
