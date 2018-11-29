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
        int i, len, c = sc.nextInt();
        int d0[], d1[];
        for(int t = 1; t <= c; t++) {
            System.out.print("Case #" + t + ": ");
            len = sc.nextInt();
            d0 = new int[len / 2 + (len % 2)];
            d1 = new int[len / 2];
            for(i = 0; i < len; i++) {
                if(i % 2 == 0)
                    d0[i / 2] = sc.nextInt();
                else
                    d1[i / 2] = sc.nextInt();
            }
            Arrays.sort(d0);
            Arrays.sort(d1);
            for(i = 0; i < len - 1; i++) {
                if((i % 2 == 0 && d0[i / 2] > d1[i / 2]) || (i % 2 == 1 && d1[i / 2] > d0[i / 2 + 1])){
                    System.out.println(i);
                    break;
                }
            }
            if(i == len - 1)
                System.out.println("OK");
        }
    }
}
