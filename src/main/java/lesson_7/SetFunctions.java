package lesson_7;

public class SetFunctions {
    public long calcFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Ошибка: введено отрицательное число");
        }
        if (n > 12) {
            throw new ArithmeticException("Ошибка: введено число более 12");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public double calcArea(double legA, double legB) {
        return legA * legB / 2;
    }

    public int calcAddition(int n1, int n2) {
        return n1 + n2;
    }

    public int calcSubtraction(int n1, int n2) {
        return n1 - n2;
    }

    public int calcMultiplication(int n1, int n2) {
         return n1 * n2;
    }

    public double calcDivision(double n1, double n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Ошибка: деление на нуль невозможна");
        }
        return n1 / n2;
    }
}
