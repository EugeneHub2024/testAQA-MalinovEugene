package lesson_7_junit_5;

import lesson_7.SetFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MyFirstTest {
    private final SetFunctions function = new SetFunctions();

    @DisplayName("Вычисление факториала числа до 7!")
    @ParameterizedTest
    @CsvSource({"1, 0", "1, 1", "2, 2", "6, 3", "24, 4", "120, 5", "720, 6", "5040, 7"})
    public void testingFactorial(long expected, int input) {
        Assertions.assertEquals(expected, function.calcFactorial(input));
    }

    @Test
    @DisplayName("Факториал отрицательного числа должен вызывать ошибку")
    public void testingFactorialThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            function.calcFactorial(-5);
        });
    }

    @Test
    @DisplayName("Факториал числа больше 12 должен вызывать ошибку")
    public void testingTooLargeFactorialThrowsException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            function.calcFactorial(13);
        });
    }

    @DisplayName("Вычисление площади прямоугольного треугольника")
    @ParameterizedTest
    @CsvSource({"5, 5, 12.5", "4, 7, 14.0", "9, 3, 13.5", "10, 6, 30.0", "13, 18, 117.0"})
    public void testingAreaTriangle(double legA, double legB, double expected) {
        Assertions.assertEquals(expected, function.calcArea(legA, legB), 0.001);
    }

    @DisplayName("Арифметическое действие - сложение")
    @ParameterizedTest
    @CsvSource({"5, 5, 10", "4, 7, 11", "9, 3, 12", "10, 6, 16", "13, 18, 31"})
    public void testingArithmeticAddition(int n1, int n2, int expected) {
        Assertions.assertEquals(expected, function.calcAddition(n1, n2));
    }

    @DisplayName("Арифметическое действие - вычитание")
    @ParameterizedTest
    @CsvSource({"5, 5, 0", "4, 7, -3", "9, 3, 6", "10, 6, 4", "13, 18, -5"})
    public void testingArithmeticSubtraction(int n1, int n2, int expected) {
        Assertions.assertEquals(expected, function.calcSubtraction(n1, n2));
    }

    @DisplayName("Арифметическое действие - умножение")
    @ParameterizedTest
    @CsvSource({"5, 5, 25", "4, 7, 28", "9, 3, 27", "10, 6, 60", "13, 18, 234"})
    public void testingArithmeticMultiplication(int n1, int n2, int expected) {
        Assertions.assertEquals(expected, function.calcMultiplication(n1, n2));
    }

    @DisplayName("Арифметическое действие - деление")
    @ParameterizedTest
    @CsvSource({"5, 5, 1", "4, 7, 0.57", "9, 3, 3", "10, 6, 1.67", "13, 18, 0.72"})
    public void testingArithmeticDivision(double n1, double n2, double expected) {
        Assertions.assertEquals(expected, function.calcDivision(n1, n2), 0.01);
    }

    @Test
    @DisplayName("Деление на нуль должно вызывать ошибку")
    public void testingZeroThrowsException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            function.calcDivision(10, 0);
        });
    }

    @DisplayName("Сравнение двух целых чисел")
    @ParameterizedTest
    @CsvSource({"5, 5", "4, 4", "9, 9", "10, 10", "13, 13"})
    public void testingEqualsNumbers(int expected, int actual) {
        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("Сравнение двух целых чисел v2")
    @ParameterizedTest
    @ValueSource(ints = {5, 4, 9, 10, 13})
    public void testingEqualsNumbersV2(int number) {
        Assertions.assertEquals(number, number);
    }
}