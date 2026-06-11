package lesson_6.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {
    private HashMap<String, ArrayList<String>> directory = new HashMap<>();

    public void addClient(String name, ArrayList<String> phones) {
        if (!directory.containsKey(name)) {
            directory.put(name, new ArrayList<>());
        }
        directory.get(name).addAll(phones);
    }

    public void getClient(String name) {
        if (directory.containsKey(name)) {
            System.out.println("Абонент: " + name + ", номера телефонов: " + directory.get(name));
        } else {
            System.out.println("Абонент " + name + " не найден.");
        }
    }

    public void printAllClient() {
        for (Map.Entry<String, ArrayList<String>> client : directory.entrySet()) {
            System.out.println("Абонент: " + client.getKey() + ", номера телефонов: " + client.getValue());
        }
        System.out.println();
    }
}
