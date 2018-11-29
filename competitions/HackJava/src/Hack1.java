import java.util.Scanner;

public class Hack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        int c = 1;
        while(sc.hasNext()) {
            line = sc.nextLine();
            System.out.println(c + " " + line);
            c++;
        }
    }
}
