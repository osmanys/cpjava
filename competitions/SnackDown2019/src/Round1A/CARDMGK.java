package Round1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CARDMGK {

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
        int sh, d[], n, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            d = new int[n];
            sh = 0;
            for(int i = 0; i < n; i++)
                d[i] = sc.nextInt();
            for(int i = 1; i < n; i++)
                if(d[i] < d[i - 1])
                    sh++;
            System.out.println(sh == 0 || (sh == 1 && d[0] >= d[d.length - 1]) ? "YES" : "NO");
        }
    }
}
