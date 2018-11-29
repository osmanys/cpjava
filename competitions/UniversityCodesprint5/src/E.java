import java.io.*;
import java.util.*;

public class E {

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

    static final int MAXN = 1000001;
    static int spf[] = new int[MAXN];
    static int div[] = new int[MAXN];
    static int fct[] = new int[MAXN];

    static void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;

        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;

        for (int i = 3; i * i < MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAXN; j += i)
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    static void fact() {
        int x, count, sp;
        for (int i = 2; i < MAXN; i++) {
            x = i;
            fct[i] = 0;
            div[i] = 1;
            while (x != 1) {
                count = 0;
                sp = spf[x];
                while (x % sp == 0) {
                    x = x / sp;
                    count++;
                }
                fct[i]++;
                div[i] *= count + 1;
            }
        }
    }

    public static void main (String[] args) {
        sieve();
        fact();
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        long n, r, c, cbrt;
        while(t-- > 0){
            n = sc.nextLong();
            r = 0;
            cbrt = (long)Math.cbrt(n);
            for(int i = 2; i <= cbrt; i++) {
                if(div[i] > Math.pow(2, fct[i]))
                    continue;
                c = n / ((long)i * i * i);
                r += c * (fct[i] % 2 == 1 ? 1 : -1);
            }
            System.out.println(r);
        }
    }
}
