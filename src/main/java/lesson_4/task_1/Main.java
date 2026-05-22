package lesson_4.task_1;

public class Main {
    public static void main(String[] args) {
      Cat cat1 = new Cat("Кот", "Барсик");
      Cat cat2 = new Cat("Кот", "Матроскин");
      Dog dog1 = new Dog("Пес", "Барбос");
      Dog dog2 = new Dog("Пес", "Шарик");

      System.out.println("Задание 1");

      cat1.run(100);
      cat1.swim(10);

      cat2.run(201);
      cat2.swim(50);

      dog1.run(400);
      dog1.swim(10);

      dog2.run(501);
      dog2.swim(11);

      Animal.getAnimalCount();

      Cat[] cats = {cat1, cat2};

      Bowl bowl = new Bowl();

      System.out.println();
      System.out.println("Еды в миске до кормления: " + bowl.getFoodAmount() + " единиц еды");
      System.out.println();

      for (Cat cat : cats) {
        cat.eat(bowl, 15);
      }

      System.out.println();
      System.out.println("Еды в миске после кормления: " + bowl.getFoodAmount() + " единиц еды");

      System.out.println("\nИнформация о сытости котов:");
      for (Cat cat : cats) {
        System.out.println("Кот " + cat.name + " сытый? " + cat.isSatiety());
      }

      System.out.println("\nДобавляем еду в миску:");
      bowl.addFood(30);
    }
}


