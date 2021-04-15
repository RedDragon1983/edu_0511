/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        int t = 0;
        for(int i = 0; i < (args.length-1); i++){
            if (args[i] == args[i+1]) {
                t = 1;
            }
        }
        if(t == 1){
            System.out.println("да");
        }else {
            System.out.println("нет");
        }
    }
}
