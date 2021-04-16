/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5, 6, 7, 8};
        boolean five = false;
        for (int i = 0; i < ints.length; i++){
            if (ints[i] == 5)
                five = true;
        }
        if (five) {
            System.out.println("да");
        } else {
            System.out.println("нет");
        }
    }
}
