import java.io.*;
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
        int s, mi, n = sc.nextInt();
        List<Double> d = new ArrayList<>();
        double p[] = new double[n];
        for(int i = 0; i < n; i++){
            mi = sc.nextInt();
            for(int j = 0; j < mi; j++) {
                s = sc.nextInt();
                p[i] += s;
                d.add((double)s);
            }
            p[i] = p[i] / mi;
        }
        Collections.sort(d);
        double ac[] = new double[d.size() + 1];
        for(int i = 1; i <= d.size(); i++)
            ac[i] = ac[i - 1] + d.get(i - 1);
        double min = Double.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            mi = Collections.binarySearch(d, p[i]);
            mi = mi < 0 ? - mi - 1 : mi;
            if (min > (mi * p[i] - ac[mi]) + (ac[d.size()] - ac[mi] - (d.size() - mi) * p[i]))
                min = (mi * p[i] - ac[mi]) + (ac[d.size()] - ac[mi] - (d.size() - mi) * p[i]);
        }
        System.out.println(min);
    }
}
