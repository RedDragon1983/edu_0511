/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int[] ints = {2, 3, 4, 5};
        int composition = 1;
        for (int i = 0; i < ints.length; i++){
            composition*=ints[i];
        }
        System.out.println(composition);
    }
}
