import java.util.Scanner;

class GIT01 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m1, m2, n, m, t = sc.nextInt();
        String[] d;
        while(t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            d = new String[n];
            for(int i = 0; i < n; i++)
                    d[i] = sc.next();
            m1 = 0;
            m2 = 0;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++) {
                    if((i + j) % 2 == 0){
                        if(d[i].charAt(j) == 'R')
                            m1 += 5;
                        else
                            m2 += 3;
                    }
                    else{
                        if(d[i].charAt(j) == 'R')
                            m2 += 5;
                        else
                            m1 += 3;
                    }
                }
            System.out.println(m1 > m2 ? m2 : m1);
        }
    }
}
