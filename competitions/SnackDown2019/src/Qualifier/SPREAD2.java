package Qualifier;

import java.io.*;
import java.util.*;

public class SPREAD2 {

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
        int l, d, n, t = sc.nextInt();
        long a[];
        while(t-- > 0){
            n = sc.nextInt();
            a = new long[n];
            a[0] = sc.nextInt();
            for(int i = 1; i < n; i++)
                a[i] = a[i - 1] + sc.nextInt();
            d = 1;
            l = 0;
            while(l + a[l] < n - 1){
                l += a[l];
                d++;
            }
            System.out.println(d);
        }
    }
}
