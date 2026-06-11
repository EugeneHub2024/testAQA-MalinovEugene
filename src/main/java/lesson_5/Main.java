package lesson_5;

public class Main {
    public static void main(String[] args) {
        String[][] baseArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] anotherSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };

        String[][] anotherDataArray = {
                {"1", "2", "3", "4"},
                {"5", "$", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        int[] smallArray = {1, 2, 3};

        ArrayProcessor processor = new ArrayProcessor();

        try {
            System.out.println("Сумма элементов: " + processor.processArray(baseArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();

        try {
            int nothing = smallArray[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали ошибку: " + e.toString());
        }
    }
}
