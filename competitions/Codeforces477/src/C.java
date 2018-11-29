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
        long n = sc.nextLong();
        long m = sc.nextLong();
        int cl = sc.nextInt();
        long l[] = new long[cl];
        int ce = sc.nextInt();
        long e[] = new long[cl];
        long v = sc.nextLong();
        for(int i = 0; i < cl; i++)
            l[i] = sc.nextLong();
        for(int i = 0; i < ce; i++)
            e[i] = sc.nextLong();
        int q = sc.nextInt();
        long x1, y1, x2, y2, rl, re;
        int li, ei;
        for(int i = 0; i < q; i++){
            x1 = sc.nextLong();
            y1 = sc.nextLong();
            x2 = sc.nextLong();
            y2 = sc.nextLong();
            rl = Long.MAX_VALUE;
            re = Long.MAX_VALUE;
            if(x1 != x2) {
                if (cl > 0) {
                    li = lower_bound(l, y1, 0, cl - 1);
                    rl = Math.abs(l[li] - y1) + Math.abs(l[li] - y2);
                    if (l[li] > y1 && li > 0)
                        li--;
                    else if (l[li] < y1 && li < cl - 1)
                        li++;
                    if (rl > Math.abs(l[li] - y1) + Math.abs(l[li] - y2))
                        rl = Math.abs(l[li] - y1) + Math.abs(l[li] - y2);
                    rl += Math.abs(x1 - x2);
                }
                if (ce > 0) {
                    ei = lower_bound(e, y1, 0, ce - 1);
                    re = Math.abs(e[ei] - y1) + Math.abs(e[ei] - y2);
                    if (e[ei] > y1 && ei > 0)
                        ei--;
                    else if (e[ei] < y1 && ei < ce - 1)
                        ei++;
                    if (re > Math.abs(e[ei] - y1) + Math.abs(e[ei] - y2))
                        re = Math.abs(e[ei] - y1) + Math.abs(e[ei] - y2);
                    re += Math.abs(x1 - x2) / v + (Math.abs(x1 - x2) % v > 0 ? 1 : 0);
                }
            }
            else
                rl = Math.abs(y1 - y2);
            if(rl > re)
                rl = re;
            System.out.println(rl);
        }
    }

    static int lower_bound(long v[], long val, int s, int e){
        if(s == e)
            return s;
        int mid = (s + e) / 2;
        if(v[mid] < val)
            return lower_bound(v, val, mid + 1, e);
        else
            return lower_bound(v, val, s, mid);
    }
}
