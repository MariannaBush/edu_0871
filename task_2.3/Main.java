/*
Вывести на экран произведение 10 чисел от 1 до 10.
Результат - это 1 число.
Подсказка:
будет три миллиона с хвостиком.
Требования:
•	Программа должна выводить целое число на экран.
•	Метод main должен вызывать функцию System.out.println.
•	Выведенное число должно быть больше трех миллионов.
•	Выведенное число должно соответствовать заданию.
*/
/** надо решить с помощью цикла */

/* Вариант решения 1
public class Main {
    public static void main(String[] args) {
        System.out.println(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10); }
}
*/

public class Main {
     public static void main(String[] args) {
         int result = 2;
         for(int i = 3; i < 11; i++)
             result *= i;
         System.out.println(result);

    }
}
