import java.io.*;
import java.util.*;

public class MIXCOLOR {

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
        int r, n, t = sc.nextInt();
        int d[];
        while(t-- > 0) {
            n = sc.nextInt();
            d = new int[n];
            for(int i = 0; i < n; i++)
                d[i] = sc.nextInt();
            Arrays.sort(d);
            r = 0;
            for(int i = 1; i < n; i++)
                if(d[i] == d[i - 1])
                    r++;
            System.out.println(r);
        }
    }
}
