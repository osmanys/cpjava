import java.io.*;
import java.util.*;

public class A {

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
        int c, _r, r, total, d, n = sc.nextInt();
        String p;
        Vector<Integer> l;
        for(int t = 1; t <= n; t++){
            System.out.print("Case #" + t + ": ");
            d = sc.nextInt();
            p = sc.next();
            l = new Vector<>();
            total = 0;
            for(int i = 0; i < p.length(); i++){
                if(p.charAt(i) == 'C')
                    l.add(i);
                else
                    total += Math.pow(2, l.size());
            }
            if(d < p.length() - l.size())
                System.out.println("IMPOSSIBLE");
            else {
                r = 0;
                c = l.size();
                while (total > d) {
                    _r = (total - d) / ((int)Math.pow(2, c - 1));
                    if((total - d) % ((int)Math.pow(2, c - 1)) > 0)
                        _r++;
                    if(_r > p.length() - 1 - l.size() + c - l.get(c - 1))
                        _r = p.length() - 1 - l.size() + c - l.get(c - 1);
                    total -= _r * Math.pow(2, c - 1);
                    r += _r;
                    c--;
                }
                System.out.println(r);
            }
        }
    }
}
