import java.io.*;
import java.util.*;

public class MAXPARTI {

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
        int idx, count, r, n, k, t = sc.nextInt();
        Integer c[];
        while(t-- > 0){
            n = sc.nextInt();
            k = sc.nextInt();
            c = new Integer[1000001];
            for(int i = 0; i < 1000001; i++)
                c[i] = 0;
            for(int i = 0; i < n; i++)
                c[sc.nextInt()]++;
            for(int i = 1; i <= k; i++){
                count = i;
                r = 0;
                idx = 1000000;
                while(count > 0){
                    if(c[idx] == 0){
                        idx--;
                        continue;
                    }
                    if(c[idx] <= count){
                        r += idx * c[idx];
                        count -= c[idx];
                        idx--;
                    }
                    else{
                        r += idx * (count - 1);
                        count = 1;
                        if((c[idx] - count) % 2 == 0){
                            count = 0;
                            r += idx;
                        }
                        else
                            idx--;
                    }
                }
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
