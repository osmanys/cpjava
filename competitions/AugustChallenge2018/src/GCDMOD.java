import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class GCDMOD {

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

    static long power(long x, long y, long p) {
        BigInteger _x = BigInteger.valueOf(x);
        BigInteger _y = BigInteger.valueOf(y);
        BigInteger _p = BigInteger.valueOf(p);

        BigInteger res = BigInteger.ONE;
        _x = _x.remainder(_p);

        while (_y.compareTo(BigInteger.ZERO) > 0) {
            if (_y.getLowestSetBit() == 1)
                res = res.multiply(_x).remainder(_p);

            _y = _y.divide(BigInteger.TWO);
            _x = _x.multiply(_x).remainder(_p);
        }
        return res.longValue();
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    static final int MOD = 1000000007;

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        long tmp, a, b, n;
        while(t-- > 0){
            a = sc.nextLong();
            b = sc.nextLong();
            n = sc.nextLong();
            tmp = a - b;
            b = 2 * power(b, n, a - b > 0 ? a - b : MOD);
            System.out.println(gcd(b, tmp) % MOD);
        }
    }
}
