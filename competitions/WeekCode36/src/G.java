import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {

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

    static final int MOD = 1000000007;

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x[] = new int[n];
        for(int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        int y[] = new int[n];
        for(int i = 0; i < n; i++)
            y[i] = sc.nextInt();
        int z[] = new int[n];
        for(int i = 0; i < n; i++)
            z[i] = sc.nextInt();
        long mx;
        int g = 0, l;
        int h[] = new int[n];
        int c[] = new int[n];
        for(int i = 0; i < n; i++){
            h[i] = x[i] ^ g;
            c[i] = y[i] ^ g;
            l = z[i] ^ g;
            mx = Long.MIN_VALUE;
            for(int j = 0; j <= i - l; j++)
                if(1L * h[j] * c[i] - 1L * c[j] * h[i] > mx)
                    mx = 1L * h[j] * c[i] - 1L * c[j] * h[i];
            g = (int)((((mx + g) % MOD) + MOD) % MOD);
        }
        System.out.println(g);
    }
}
