/*Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
... */
public class Main {
    public static void main(String[] args) {
        //напишите тут ваш код
        String t;
        for(int i = 1; i < 11; i++){
            t="";
            for(int j = 1; j < 11; j++){
                t+=(i*j)+" ";
            }
            System.out.println(t);
        }
    }
}
