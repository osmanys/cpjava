import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BROCLK {

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

    static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            int q = a / m;

            int t = m;

            m = a % m;
            a = t;
            t = y;

            y = x - q * y;
            x = t;
        }

        if (x < 0)
            x += m0;

        return x;
    }

    static class Rational{
        long P;
        long Q;

        Rational(long p, long q){
            this.P = p;
            this.Q = q;
        }
    }

    static Rational calcT(long t, int d, int l, int MOD, HashMap<Long, Rational> map){
        if(t == 0)
            return new Rational(1, 1);
        else if(t == 1)
            return new Rational(d % MOD, l % MOD);
        if(t % 2 == 0){
            Rational tmp;
            if(!map.containsKey(t / 2)) {
                tmp = calcT(t / 2, d, l, MOD, map);
                map.put(t / 2, tmp);
            }
            else
                tmp = map.get(t / 2);
            return new Rational((2 * tmp.P * tmp.P - tmp.Q * tmp.Q) % MOD, (tmp.Q * tmp.Q) % MOD);
        }
        else{
            Rational tmp0, tmp1;
            if(!map.containsKey(t / 2)) {
                tmp0 = calcT(t / 2, d, l, MOD, map);
                map.put(t / 2, tmp0);
            }
            else
                tmp0 = map.get(t / 2);
            if(!map.containsKey(t / 2 + 1)) {
                tmp1 = calcT(t / 2 + 1, d, l, MOD, map);
                map.put(t / 2 + 1, tmp1);
            }
            else
                tmp1 = map.get(t / 2 + 1);
            long tmp = (tmp0.Q * tmp1.Q) % MOD;
            return new Rational((2 * tmp0.P * tmp1.P - d * ((modInverse(l, MOD) * tmp) % MOD)) % MOD, tmp);
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        long t;
        Rational p;
        int r, l, d, T = sc.nextInt();
        while(T-- > 0){
            l = sc.nextInt();
            d = sc.nextInt();
            t = sc.nextLong();
            HashMap<Long, Rational> map = new HashMap<>();
            p = calcT(t, d, l, MOD, map);
            r = modInverse((int)p.Q, MOD);
            System.out.println(((l * ((p.P * r) % MOD)) % MOD + MOD) % MOD);
        }
    }
}
