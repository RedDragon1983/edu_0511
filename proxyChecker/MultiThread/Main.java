package MultiThrad;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Моем посуду выпонено: "+i+"%");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Стираем бельё: "+i+"%");
                }
            }
        });
        thread1.start();
        thread2.start();
        /* Способ 2
        Thread myRunnableThread1 = new Thread(new MyRunnableThread("Моем посуду"));
        Thread myRunnableThread2 = new Thread(new MyRunnableThread("Стираем бельё"));
        myRunnableThread1.start();
        myRunnableThread2.start();*/
        /* Способ 1
        MyThread myThread1 = new MyThread("Моем посуду");
        MyThread myThread2 = new MyThread("Стираем бельё");
        myThread1.start();
        myThread2.start();*/
    }
}

class MyRunnableThread implements Runnable{
    private String task;
    public MyRunnableThread(String task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(task+" выпонено: "+i+"%");
        }
    }
}


class MyThread extends Thread{
    private String task;

    public MyThread(String task) {
        super();
        this.task = task;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(task+" выпонено: "+i+"%");
        }
    }
}
