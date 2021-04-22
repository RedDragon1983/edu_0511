import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\java\\ip.txt");
            int i;
            String proxy = "";
            while ((i=fin.read()) != -1){
                if(i==13) continue;
                else if(i==10){
                    String ip = proxy.split(":")[0];
                    String port=proxy.split(":")[1];
                    System.out.println("АйПи: "+ip+" || Порт: "+port);
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
}
