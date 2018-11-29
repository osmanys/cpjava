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
        long c, r, n = sc.nextInt();
        int q = sc.nextInt();
        while(q-- > 0){
            r = sc.nextInt();
            c = sc.nextInt();
            if((c + r) % 2 == 0){
                if(r % 2 == 1)
                    System.out.println((r - 1) / 2 * n + (c + 1) / 2);
                else
                    System.out.println((r - 2) / 2 * n + n / 2 + n % 2 + c / 2);
            }
            else{
                if(r % 2 == 1)
                    System.out.println(n * n / 2 + (n * n) % 2 + (r - 1) / 2 * n + c / 2);
                else
                    System.out.println(n * n / 2 + (n * n) % 2 + (r - 2) / 2 * n + n / 2 + (c + 1) / 2);
            }
        }
    }
}
