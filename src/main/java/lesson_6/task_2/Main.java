package lesson_6.task_2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        ArrayList<String> phonesMalinov = new ArrayList<>();
        phonesMalinov.add("+7 937 277 40 40");
        phonesMalinov.add("+7 927 277 41 41");
        phonesMalinov.add("+7 917 277 42 42");

        ArrayList<String> phonesGorshkov = new ArrayList<>();
        phonesGorshkov.add("+7 937 266 43 43");
        phonesGorshkov.add("+7 927 266 44 44");
        phonesGorshkov.add("+7 917 266 45 45");

        ArrayList<String> phonesVoronova = new ArrayList<>();
        phonesVoronova.add("+7 937 255 46 46");
        phonesVoronova.add("+7 927 255 47 47");
        phonesVoronova.add("+7 917 255 48 48");

        ArrayList<String> phonesSmirnov = new ArrayList<>();
        phonesSmirnov.add("+7 999 999 99 99");

        phoneDirectory.addClient("Малинов Евгений", phonesMalinov);
        phoneDirectory.addClient("Горшков Иван", phonesGorshkov);
        phoneDirectory.addClient("Воронова Ольга", phonesVoronova);
        phoneDirectory.printAllClient();

        phoneDirectory.addClient("Смирнов Николай", phonesSmirnov);
        phoneDirectory.printAllClient();

        phoneDirectory.getClient("Воронова Ольга");
    }
}
