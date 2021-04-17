/*
ВНИМАНИЕ эта задача для ДЗ и не является обязательной.
Задание: 1. Создай массив чисел.
2. Добавь в массив 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3
*/

public class Main {
    public static void main(String[] args) {
        int num[] = new int[10];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++){
            num[i] = s.nextInt();
        }
        int max = 1;
        int same = 1;
        int last = 0;
        for (int i = 0; i < num.length; i++){
            if(last == num[i]){
                same++;
            }else {
                if(same > max){
                    max = same;
                }
                same = 1;
            }
            last = num[i];
        }
        System.out.println(max);
    }
}
