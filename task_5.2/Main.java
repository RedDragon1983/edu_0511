/*
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


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hashMap = new HashMap<>();
        while (true) {
            String family = scanner.nextLine();
            if (family.isEmpty()) {
                break;
            }
            hashMap.put(family, scanner.nextLine());
        }
        String sity = scanner.nextLine();
        for (Map.Entry<String, String> entry: hashMap.entrySet()) {
            if(sity == entry.getKey())
                System.out.println(entry.getValue());
        }
    }
}
