package qualification;

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
        int n, c = sc.nextInt();
        StringBuilder sb;
        String p;
        for(int t = 1; t <= c; t++) {
            sb = new StringBuilder();
            n = sc.nextInt();
            p = sc.next();
            for(int i = 0; i < 2 * n - 2; i++){
                if(p.charAt(i) == 'E')
                    sb.append('S');
                else
                    sb.append('E');
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
