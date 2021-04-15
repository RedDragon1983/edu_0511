/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int t = 1;
        int t2 = 0;
        for(int i = 0; i < args.length; i++){
            t++;
            t2+=Integer.parseInt(args[i]);
            if (t2 > 10) {
                System.out.println(t);
                break;
            }
        }

    }
}
