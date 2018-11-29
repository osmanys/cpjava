import java.io.*;
import java.util.*;

public class D {

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
        int cs, r, n, l, c = sc.nextInt();
        int v[];
        double d, diff;
        for(int t = 1; t <= c; t++) {
            System.out.print("Case #" + t + ": ");
            n = sc.nextInt();
            l = sc.nextInt();
            v = new int[l];
            cs = 0;
            r = 0;
            for(int i = 0; i < l; i++)
                cs += v[i] = sc.nextInt();
            cs = n - cs;
            for(int i = 0; i < l; i++) {
                d = (v[i] * 100d) / n;
                if(d >= (int)d + 0.5){
                    r += (int)d + 1;
                }
                else{
                    diff = n * ((int)d + 0.5) / 100;
                    if(diff > (int)diff)
                        diff = (int)diff + 1;
                    d = (diff * 100d) / n;
                    diff -= v[i];
                    if (cs < diff || d < (int)d + 0.5)
                        r += (int) ((v[i] * 100d) / n);
                    else {
                        cs -= diff;
                        r += (int) (((v[i] + diff) * 100d) / n) + 1;
                    }
                }
            }
            if(cs > 0){
                diff = 0.5 * n / 100;
                if(diff > (int)diff)
                    diff = (int)diff + 1;
                r += cs / diff;
            }
            System.out.println(r);
        }
    }
}
