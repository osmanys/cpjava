package Round1A;

import java.io.*;
import java.util.*;

public class CHEFADD {

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

    static int calcdp(int c, int ca, int cb) {
        int dp[][][][] = new int[33][ca + 1][cb + 1][2];
        dp[0][0][0][0] = 1;
        for(int _p = 0; _p < 32; _p++) {
            for (int _ca = 0; _ca <= ca; _ca++) {
                for (int _cb = 0; _cb <= cb; _cb++) {
                    if (((c >> _p) & 1) == 1) {
                        if (_ca < ca)
                            dp[_p + 1][_ca + 1][_cb][0] += dp[_p][_ca][_cb][0];
                        if (_cb < cb)
                            dp[_p + 1][_ca][_cb + 1][0] += dp[_p][_ca][_cb][0];
                        dp[_p + 1][_ca][_cb][0] += dp[_p][_ca][_cb][1];
                        if (_ca < ca && _cb < cb)
                            dp[_p + 1][_ca + 1][_cb + 1][1] += dp[_p][_ca][_cb][1];
                    } else {
                        dp[_p + 1][_ca][_cb][0] += dp[_p][_ca][_cb][0];
                        if (_ca < ca && _cb < cb)
                            dp[_p + 1][_ca + 1][_cb + 1][1] += dp[_p][_ca][_cb][0];
                        if (_ca < ca)
                            dp[_p + 1][_ca + 1][_cb][1] += dp[_p][_ca][_cb][1];
                        if (_cb < cb)
                            dp[_p + 1][_ca][_cb + 1][1] += dp[_p][_ca][_cb][1];
                    }
                }
            }
        }

        return dp[32][ca][cb][0];
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int ca, cb, a, b, c, t = sc.nextInt();
        while(t-- > 0){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            ca = 0;
            while (a > 0) {
                a &= (a - 1);
                ca++;
            }
            cb = 0;
            while (b > 0) {
                b &= (b - 1);
                cb++;
            }
            System.out.println(calcdp(c, ca, cb));
        }
    }
}
