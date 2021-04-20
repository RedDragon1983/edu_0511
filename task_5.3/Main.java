/*
* Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
* Коллекции вы создаёте сами
*/

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> allNumbs = new  ArrayList<>();
        ArrayList<Integer> total = new  ArrayList<>(); // новая коллекция
        Random r = new Random();
        for (int i = 0; i < 50_000; i++){
            allNumbs.add(r.nextInt(50));
        }
        for (Integer j : allNumbs){
            if(j > 0 && j < 10)
                total.add(j);
        }
        System.out.println(total);
    }
}
