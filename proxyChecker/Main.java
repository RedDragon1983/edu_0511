import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.io.FileWriter;
/*
* task_7.1 - реализовать многопоточность в прокси чеккере первым и вторым способом
* task_7.2 - рабочие ip адреса необходимо складывать в файл good.txt
*  */

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\java\\ip.txt");
            //FileInputStream fin = new FileInputStream("C:\\edu_0511_java\\ip.txt");

            ArrayList<CheckProxy> arrayList = new ArrayList<>();
            ArrayList<Thread> arrayList2 = new ArrayList<>();

            int i;
            String proxy = "";
            while ((i=fin.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    final String ip = proxy.split(":")[0];
                    final String port=proxy.split(":")[1];
                    Thread thread = new Thread(new Runnable() { // Многопоточный способ № 3
                        @Override
                        public void run() {
                            System.out.println(checkProxy(ip,Integer.parseInt(port)));
                        }
                    });
                    thread.start();

                    /*CheckProxy checkProxy = new CheckProxy(ip, Integer.parseInt(port)); // Многопоточный способо № 1
                    checkProxy.start();
                    arrayList.add(checkProxy);*/

                    /*Thread thread = new Thread(new CheckProxy2(ip, Integer.parseInt(port))); // Многопоточнфй способ № 2
                    thread.start();
                    arrayList2.add(thread);*/

                    proxy ="";
                }else if(i != 9){
                    proxy += (char)i;
                }else{
                    proxy += ":";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            FileOutputStream fout = new FileOutputStream("C:\\java\\test.txt");
            String text = "Hello!";
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            fout.write(bytes);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static String checkProxy (String ip, int port){
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip, port));
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1){
                sb.append((char)rc);
            }
            
            // Запись работающих PROXY в файл
            File file = new File("C:\\java\\work_ip.txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file, true);
                fr.write("IP: "+ip+":"+port+" работает\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            return "IP: "+ip+":"+port+ANSI_GREEN+" работает"+ANSI_RESET;
        } catch (Exception e) {
            return "IP: "+ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET;
        }
    }

}

class CheckProxy extends Thread{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String ip;
    private int port;

    public CheckProxy(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip, port));
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1){
                sb.append((char)rc);
            }
            System.out.println("IP: "+ip+":"+port+ANSI_GREEN+" работает"+ANSI_RESET);
        } catch (Exception e) {
            System.out.println("IP: "+ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET);
        }
    }
}

class CheckProxy2 implements Runnable{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String ip;
    private int port;

    public CheckProxy2(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip, port));
            URLConnection urlConnection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read()) != -1){
                sb.append((char)rc);
            }
            System.out.println("IP: "+ip+":"+port+ANSI_GREEN+" работает"+ANSI_RESET);
        } catch (Exception e) {
            System.out.println("IP: "+ip+":"+port+ANSI_RED+" не работает"+ANSI_RESET);
        }
    }
}
