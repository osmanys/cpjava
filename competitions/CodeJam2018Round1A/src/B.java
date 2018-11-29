import java.io.*;
import java.util.*;

public class B {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int r, b, c, T = sc.nextInt();
        int m[], s[], p[];
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            r = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            m = new int[c];
            s = new int[c];
            p = new int[c];
            for(int i = 0; i < c; i++){
                m[i] = sc.nextInt();
                s[i] = sc.nextInt();
                p[i] = sc.nextInt();
            }
            System.out.println(calc(r, b, c, m, s, p));
        }
    }

    static int calc(int r, int b, int c, int m[], int s[], int p[]){
        Vector<Vector<Integer>> cashiers = selectCashiers(r, c);
        int t, min = Integer.MAX_VALUE;
        for(int i = 0; i < cashiers.size(); i++){
            t = calcTime(cashiers.get(i), b, m, s, p, 0, 0);
            if(t < min)
                min = t;
        }
        return min;
    }

    static int calcTime(Vector<Integer> cash, int b, int m[], int s[], int p[], int pos, int ac){
        if(pos == cash.size() - 1){
            if(m[pos] < b - ac)
                return Integer.MAX_VALUE;
            return s[pos] * (b - ac) + p[pos];
        }
        if(ac == b)
            return 0;
        int c, min = Integer.MAX_VALUE;
        for(int i = ac; i < b; i++){
            if(i - ac > m[pos])
                break;
            c = calcTime(cash, b, m, s, p, pos + 1, i);
            if(c < Integer.MAX_VALUE && min > Math.max(c, s[pos] * (i - ac) + p[pos]))
                min = Math.max(c, s[pos] * (i - ac) + p[pos]);
        }
        return min;
    }

    static Vector<Vector<Integer>> selectCashiers(int r, int c){
        int M = (int)Math.pow(2, c);
        Vector<Integer> comb;
        Vector<Vector<Integer>> res = new Vector<>();
        for(int i = 0; i < M; i++){
            comb = countBit(i);
            if(comb.size() == r)
                res.add(comb);
        }
        return res;
    }

    static Vector<Integer> countBit(int b){
        Vector<Integer> r = new Vector<>();
        int i = 0;
        while(b > 0){
            if(b % 2 == 1)
                r.add(i);
            b /= 2;
            i++;
        }
        return r;
    }
}
