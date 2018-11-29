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
        int i, n, t = sc.nextInt();
        String s;
        while(t-- > 0){
            n = sc.nextInt();
            s = sc.next();
            for(i = 0; i < n / 2; i++)
                if(Math.abs(s.charAt(i) - s.charAt(n - i - 1)) != 2 && Math.abs(s.charAt(i) - s.charAt(n - i - 1)) != 0)
                    break;
            if(i < n / 2)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
