  
/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */

public class Main {
    public static void main(String[] args) {   
        String[] strings = {"Мама", "Мыла", "Раму"};
        String out, out2 = "";
        for (int i = 0; i < strings.length; i++){
            out = strings[i];
            for (int g = 0; g < strings.length; g++){
                if(g != i){
                    out2 = strings[g];
                    for (int d = 0; d < strings.length; d++){
                        if(d != i && d != g) {
                            System.out.println(out+out2+strings[d]);
                        }
                    }
                }
            }
        }
    }
}
