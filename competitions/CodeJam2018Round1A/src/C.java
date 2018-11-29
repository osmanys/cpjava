import java.io.*;
import java.util.*;

public class C {

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
        int n, p, T = sc.nextInt();
        int w[], h[];
        double d;
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            n = sc.nextInt();
            p = sc.nextInt();
            w = new int[n];
            h = new int[n];
            d = 0;
            for(int i = 0; i < n; i++){
                w[i] = sc.nextInt();
                h[i] = sc.nextInt();
                d += 2 * (w[i] + h[i] + Math.sqrt(w[i] * w[i] + h[i] * h[i]));
            }
            if(d > p)
                System.out.println((double)p);
            else
                System.out.println(d);
        }
    }
}
