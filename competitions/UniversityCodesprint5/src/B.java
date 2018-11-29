import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    static int calc(int d[], int idx, long a, int ca, long b, int cb, long c, int cc){
        if(idx == d.length)
            return (ca > 0 && cb > 0 && cc > 0 && a == b && b == c) ? 1 : 0;
        return calc(d, idx + 1, a + d[idx], ca + 1, b, cb, c, cc)
                + calc(d, idx + 1, a, ca, b + d[idx], cb + 1, c, cc)
                + calc(d, idx + 1, a, ca, b, cb, c + d[idx], cc + 1);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int d[] = new int[n];
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
        System.out.println(calc(d, 0, 0, 0, 0, 0, 0, 0));
    }
}
