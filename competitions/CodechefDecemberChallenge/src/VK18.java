import java.util.Scanner;

class VK18 {
    private static final int MAX = 2000002;
    private static long[] mult = new long[MAX];
    private static long[] rmult = new long[MAX];
    private static long[] rsum = new long[MAX];

    private static void build(){
        int d, m;
        long s = 0;
        for(int i = 2; i <= MAX - 2; i++){
            d = 0;
            m = 1;
            while(i / m > 0){
                if(((i / m) % 10) % 2 == 0)
                    d += (i / m) % 10;
                else
                    d -= (i / m) % 10;
                m *= 10;
            }
            s += (i - 1) * Math.abs(d);
            mult[i] = s;
        }
        s = 0;
        long s2 = 0;
        for(int i = MAX - 2; i >= 2; i--){
            d = 0;
            m = 1;
            while(i / m > 0){
                if(((i / m) % 10) % 2 == 0)
                    d += (i / m) % 10;
                else
                    d -= (i / m) % 10;
                m *= 10;
            }
            s += (MAX - i + 1) * Math.abs(d);
            s2 += Math.abs(d);
            rmult[i] = s;
            rsum[i] = s2;
        }
    }

    public static void main(String args[]){
        build();
        Scanner sc = new Scanner(System.in);
        int n, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            System.out.println(mult[n + 1] + (rmult[n + 2] - rmult[2 * n + 1]) - (MAX - 2 * n) * (rsum[n + 2] - rsum[2 * n + 1]));
        }
    }
}
