import java.io.*;
import java.util.*;

public class BSHUFFLE_TEST {

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

    static void shuffle(int d[], int n, HashMap<String, Long> r, int idx){
        if(idx == n){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < n; i++)
                sb.append(d[i]);
            String s = sb.toString();
            if(r.containsKey(s))
                r.replace(s, r.get(s) + 1);
            else
                r.put(s, 1L);
        }
        else{
            for(int i = 0; i < n; i++){
                int tmp = d[i];
                d[i] = d[idx];
                d[idx] = tmp;
                shuffle(d, n, r, idx + 1);
                tmp = d[i];
                d[i] = d[idx];
                d[idx] = tmp;
            }
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int d[] = new int[n];
        for(int i = 1; i <= n; i++)
            d[i - 1] = i;
        HashMap<String, Long> r = new HashMap<>();
        shuffle(d, n, r, 0);
        r.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .limit(10).forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }
}
