/*
* Дана коллекция имён.
* 1) удалить все повторяющиеся имена из коллекции
* 2) вывести коллекцию на экран
* */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        ArrayList<String> test = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");
        
        Iterator iterator = names.iterator();
        Object t = "";
        while (iterator.hasNext()) {
            t = iterator.next();
            if(test.contains(t)){
                iterator.remove();
            }else {
               test.add(t.toString());
            }
        }
        System.out.println(names);
    }
}
