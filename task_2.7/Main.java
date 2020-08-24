/*
Напиши код метода sumDigitsInNumber(int number).
Метод на вход принимает целое трехзначное число.
Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.
Пример:
Метод sumDigitsInNumber вызывается с параметром 546.
Пример вывода:
15
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

        int num1 = number / 100;
        int num2 = num1 % 10;    // вычисление остатка от целочисленного деления
        int num3 = num2 % 100;
        return num1+num2+num3;

    }
}
