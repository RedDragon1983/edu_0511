/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Double sum = s.nextDouble();
        Double p = s.nextDouble();
        Double proc = sum/100;
        Double i = sum;
        for(int h = 0; h < 5; h++){
            i+= sum + (proc*p);
            System.out.println(i);
        }
    }
}
