package lesson_4.task_1;

public class Bowl {
    protected int foodAmount;

    public Bowl() {
        this.foodAmount = 0;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount = this.foodAmount + amount;
            System.out.println("В миску добавлено " + amount + " единиц еды. Всего в миске: " + foodAmount + " единиц еды");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }

    public void decreaseFood(int amount) {
        if (amount > 0 && this.foodAmount >= amount) {
            this.foodAmount = this.foodAmount - amount;
        }
    }
}
