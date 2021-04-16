/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int num[] = {4,8,7,2,6,4,2,6,2,2};
        boolean t = false;
        for(int i = 0; i < (num.length-1); i++){
            if (num[i] == num[i+1]) {
                t = true;
            }
        }
        if(t){
            System.out.println("да");
        }else {
            System.out.println("нет");
        }
    }
}
