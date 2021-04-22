import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class GetIp {
    public static void main(String[] args) {
        try {
            URL uri = new URL("https://vozhzhaev.ru/test.php");
            BufferedReader br = new BufferedReader(new InputStreamReader(uri.openStream()));
            while (br.ready())
                System.out.println(br.readLine());
        } catch (MalformedURLException e) {

        } catch (IOException e) {

        }
    }
}
