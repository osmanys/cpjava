import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDCNT {

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
        int a[] = new int[1000000000];
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int d[] = new int[n];
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
        int x, y, l, r, g, t, q = sc.nextInt();
        for(int i = 0; i < q; i++){
            t = sc.nextInt();
            if(t == 1){
                x = sc.nextInt();
                y = sc.nextInt();

            }
            else{
                l = sc.nextInt();
                r = sc.nextInt();
                g = sc.nextInt();

            }
        }
    }
}
