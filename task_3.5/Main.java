/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        all(0, num);
    }
    public static void all(int n, int[] ar){
        System.out.println(ar[n]);
        if(n < (ar.length-1)) {
            all(n+1, ar);
        }
    }
}
