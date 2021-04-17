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
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0;
        for (int i = 0; i < num.length; i++){
            if(num[i] == last){
                if(map.containsKey(num[i])){
                    map.put(num[i],map.get(num[i])+1);
                }else {
                    map.put(num[i],2);
                }
            }
            last = num[i];
        }
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int t = 0;
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if(entry.getValue() > t)
                t = entry.getValue();
        }
        System.out.println(t);
    }
}
