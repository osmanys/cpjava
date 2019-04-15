package round1a;

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
        int tc = sc.nextInt();
        int n = sc.nextInt();
        int result, g = sc.nextInt();
        for(int t = 1; t <= tc; t++) {
            result = 0;
            for(int i = 0; i < n; i++) {

                for(int j = 0; j < 18; j++)
                    System.out.print(" ");
                System.out.println();
                System.out.flush();
            }
            System.out.println(result);
            System.out.flush();
        }
    }
}
