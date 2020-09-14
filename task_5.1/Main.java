/*
Перед решением прочтите https://www.codeflow.site/ru/article/java-buffered-reader
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,String> address = new HashMap<>();
        System.out.println("Пожалуйста, введите город и нажмите enter");
        while (true) {
            String family = reader.readLine();
            System.out.println("Пожалуйста, введите фамилию и нажмите enter");
            if (family.isEmpty()) { break; }
            String town = reader.readLine();
            System.out.println("Пожалуйста, введите город и нажмите enter");
            if (town.isEmpty()) { break; }
            address.put(town,family);
        }

        // Read the town
        String townName = reader.readLine();
        if (address.containsKey(townName)) {
            System.out.println("Живут в городе: "+address.get(townName));
        }

    }
}
