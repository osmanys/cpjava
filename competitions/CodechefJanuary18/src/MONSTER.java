import java.io.*;
import java.util.*;

public class MONSTER {

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
        int i, n = sc.nextInt();
        long[] h = new long[n];
        for(i = 0; i < n; i++)
            h[i] = sc.nextLong();
        int q = sc.nextInt();
        long[] qx = new long[q];
        long[] qy = new long[q];
        long r = 0;
        for(i = 0; i < q; i++){
            qx[i] = sc.nextLong();
            qy[i] = sc.nextLong();
            for(int j = 0; j < n; j++){
                if(h[j] > 0 && (j & qx[i]) == j){
                    h[j] -= qy[i];
                    if(h[j] <= 0)
                        r++;
                }
            }
            System.out.println(n - r);
        }
    }
}
