  
/* 
1. Ввести путь к файлу с консоли.
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String file = s.next();
        try {
            TreeSet ts = new TreeSet();
            BufferedReader br = new BufferedReader(new FileReader("C:\\edu_0511_java\\"+file));
            int temp;
            while (br.ready()){
                temp = Integer.parseInt(br.readLine().trim());
                if(temp % 2 == 0)
                    ts.add(temp);
            }
            Iterator iterator = ts.iterator();
            while(iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
