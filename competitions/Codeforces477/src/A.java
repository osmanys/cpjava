import java.io.*;
import java.util.*;

public class A {

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
        int i, h, m, n = sc.nextInt();
        int s = sc.nextInt();
        int a[] = new int[n];
        for(i = 0; i < n; i++){
            h = sc.nextInt();
            m = sc.nextInt();
            a[i] = h * 60 + m;
        }
        if(a[0] > 1 + s)
            System.out.println("0 0");
        else {
            for (i = 1; i < n; i++) {
                if (a[i] > a[i - 1] + 1 + 2 * s + 1)
                    break;
            }
            System.out.println(((a[i - 1] + 1 + s) / 60) + " " + ((a[i - 1] + 1 + s) % 60));
        }
    }
}
