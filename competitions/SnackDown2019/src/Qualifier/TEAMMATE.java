package Qualifier;

import java.io.*;
import java.util.*;

public class TEAMMATE {

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

    static final int MOD = 1000000007;
    static final int MAX = 100000;
    static int calc[];

    static void precalc(){
        calc = new int[MAX + 1];
        calc[0] = 1;
        long m = 1;
        for(int i = 2; i <= MAX; i += 2){
            m = (m * (i - 1)) % MOD;
            calc[i] = (int)m;
        }
    }

    static long comb(int i, int c){
        long m = 1;
        if((i - c) % 2 == 1) {
            m = c;
            c--;
        }
        if((i - c) % 2 == 0 && c % 2 == 1) {
            m = (m * c) % MOD;
            c--;
        }
        return (m * calc[c]) % MOD;
    }

    public static void main (String[] args) {
        precalc();
        FastReader sc = new FastReader();
        int c, s[], n, t = sc.nextInt();
        long r;
        while(t-- > 0){
            n = sc.nextInt();
            s = new int[n];
            for(int i = 0; i < n; i++)
                s[i] = sc.nextInt();
            Arrays.sort(s);
            r = 1;
            c = 1;
            for(int i = 1; i < n; i++) {
                if (s[i] == s[i - 1])
                    c++;
                else{
                    r = (r * comb(i, c)) % MOD;
                    c = 1;
                }
            }
            r = (r * comb(n, c)) % MOD;
            System.out.println(r);
        }
    }
}
