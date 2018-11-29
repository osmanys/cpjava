package Qualifier;

import java.io.*;
import java.util.*;

public class QABC {

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
        int i, a[], b[], n, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            a = new int[n];
            for(i = 0; i < n; i++)
                a[i] = sc.nextInt();
            b = new int[n];
            for(i = 0; i < n; i++)
                b[i] = sc.nextInt();
            for(i = 0; i < n - 2; i++){
                if(a[i] > b[i])
                    break;
                a[i + 2] += 3 * (b[i] - a[i]);
                a[i + 1] += 2 * (b[i] - a[i]);
                a[i] = b[i];
            }
            if(i < n - 2 || a[n - 1] != b[n - 1] || (n > 1 && a[n - 2] != b[n - 2]))
                System.out.println("NIE");
            else
                System.out.println("TAK");
        }
    }
}
