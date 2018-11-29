import java.util.Scanner;

public class template {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s;
        StringBuilder r;
        int st = 0;
        while(sc.hasNext()){
            if(st == 1 || st == 3)
                st = 0;
            s = sc.nextLine();
            r = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                if(st == 1 || st == 2)
                    r.append(s.charAt(i));
                if(st == 0) {
                    if(s.charAt(i) == '/' && (i + 1 < s.length() && s.charAt(i + 1) == '/')) {
                        st = 1;
                        r.append("//");
                        i++;
                    }
                    else if(s.charAt(i) == '/' && (i + 1 < s.length() && s.charAt(i + 1) == '*')) {
                        st = 2;
                        r.append("/*");
                        i++;
                    }
                }
                else if(st == 2) {
                    if(s.charAt(i) == '*' && (i + 1 < s.length() && s.charAt(i + 1) == '/')) {
                        st = 3;
                        r.append('/');
                        i++;
                    }
                }
            }
            System.out.print(r + (st == 1 || st == 2 || st == 3 ? "\n" : ""));
        }
    }
}
