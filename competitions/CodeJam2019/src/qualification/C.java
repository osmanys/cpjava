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
        int idx, l, c = sc.nextInt();
        BigInteger d[], r[], ord[];
        HashMap<BigInteger, Character> dict;
        StringBuilder sb;
        for(int t = 1; t <= c; t++) {
            sc.nextInt();
            l = sc.nextInt();
            d = new BigInteger[l];
            for(int i = 0; i < l; i++)
                d[i] = new BigInteger(sc.next());
            r = new BigInteger[l + 1];
            ord = new BigInteger[l + 1];
            for(int i = 1; i < l; i++) {
                if (d[i - 1].compareTo(d[i]) != 0) {
                    r[i] = gcd(d[i - 1], d[i]);
                    ord[i] = r[i];
                }
            }
            for(int i = 1; i < l; i++){
                if(r[i] == null && r[i - 1] != null) {
                    r[i] = d[i - 1].divide(r[i - 1]);
                    ord[i] = r[i];
                }
            }
            for(int i = l - 2; i >= 0; i--){
                if(r[i] == null && r[i + 1] != null) {
                    r[i] = d[i].divide(r[i + 1]);
                    ord[i] = r[i];
                }
            }
            r[l] = d[l - 1].divide(r[l - 1]);
            ord[l] = r[l];
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
