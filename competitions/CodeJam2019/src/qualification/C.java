package qualification;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C {

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
        int j, idx, l, c = sc.nextInt();
        BigInteger d[], r[], ord[];
        HashMap<BigInteger, Character> dict;
        StringBuilder sb;
        for(int t = 1; t <= c; t++) {
            sc.next();
            l = sc.nextInt();
            d = new BigInteger[l];
            for(int i = 0; i < l; i++)
                d[i] = new BigInteger(sc.next());
            r = new BigInteger[l + 1];
            ord = new BigInteger[l + 1];
            for(j = 1; j < l; j++) {
                if (d[j - 1].compareTo(d[j]) != 0) {
                    r[j] = gcd(d[j - 1], d[j]);
                    ord[j] = r[j];
                    break;
                }
            }
            for(int i = j + 1; i <= l; i++){
                r[i] = d[i - 1].divide(r[i - 1]);
                ord[i] = r[i];
            }
            for(int i = j - 1; i >= 0; i--){
                r[i] = d[i].divide(r[i + 1]);
                ord[i] = r[i];
            }
            Arrays.sort(ord);
            dict = new HashMap<>();
            idx = 0;
            for(int i = 0; i < l + 1; i++){
                if(!dict.containsKey(ord[i])) {
                    dict.put(ord[i], (char) ('A' + idx));
                    idx++;
                }
            }
            sb = new StringBuilder();
            for(int i = 0; i < l + 1; i++)
                sb.append(dict.get(r[i]));
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

    private static BigInteger gcd(BigInteger a, BigInteger b)
    {
        if (b.compareTo(BigInteger.ZERO) == 0)
            return a;
        return gcd(b, a.remainder(b));
    }
}
