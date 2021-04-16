public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,6,4,2,6,2,6};
        int t = 0;
        int t2 = 0;
        for(int i = 0; i < num.length; i++){
            t++;
            t2+=num[i];
            if (t2 > 10) {
                System.out.println(t);
                break;
            }
        }

    }
}
