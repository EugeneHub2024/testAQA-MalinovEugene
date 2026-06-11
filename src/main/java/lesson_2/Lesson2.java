package lesson_2;

import java.util.Arrays;

public class Lesson2 {
    public  static  void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        printBoolean(10, 11);
        printNumber(0);
        printNumberBoolean(-4);
        printCountString("Java", 3);
        System.out.println(printYearsBoolean(2026));
        printUpdateArray();
        printAddArray();
        printMultiplyArray();
        printTwiceArray();
        System.out.println(Arrays.toString(printReturnArray(5, 10)));
    }

    //Задание 1

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //Задание 2

    public static void checkSumSign() {
       int a = 5;
       int b = 7;
       int c = a + b;
       if (c > 0) {
           System.out.println("Сумма положительная");
       } else {
           System.out.println("Сумма отрицательная");
       }
    }

    //Задание 3

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //Задание 4

    public static void compareNumbers() {
        int a = 3;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //Задание 5

    public static void printBoolean(int a, int b) {
        int c = a + b;
        System.out.println(c >= 10 && c <= 20);
    }

    //Задание 6

    public static void printNumber(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //Задание 7

    public static void printNumberBoolean(int a) {
        System.out.println(a < 0);
    }

    //Задание 8

    public static void printCountString(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    //Задание 9

    public static boolean printYearsBoolean(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //Задание 10

    public static void printUpdateArray() {
        int [] arr = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else if (arr[i] == 0) {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание 11

    public static void printAddArray() {
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            }
        System.out.println(Arrays.toString(arr));
    }

    //Задание 12

    public static void printMultiplyArray() {
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание 13

    public static void printTwiceArray() {
        int [][] table = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j || i + j == 4) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = 0;
                }
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //Задание 14

    public static int[] printReturnArray(int len, int initialValue) {
        int [] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
