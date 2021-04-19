/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main{
    public static void main(String[] args) {
        //Ваш код
        Horse horse = new Horse();
        horse.run();
        Pegasus pegasus = new Pegasus();
        pegasus.fly();
    }
}
abstract class Animal{
    String name;
    int height;
    int tail;
}
class Horse extends Animal{
    public void run(){
        System.out.println("Игого, я поскакал");
    }
}
class Pegasus extends Horse{
    public void fly(){
        System.out.println("Игого, я полетел");
    }
}
