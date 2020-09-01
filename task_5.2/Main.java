/* 
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                arrayList.add(number);
            }
        }
        scanner.close();
        reader.close();
        Collections.sort(arrayList);
        for (Integer result : arrayList) {
            System.out.println(result);
        }
    }
}
