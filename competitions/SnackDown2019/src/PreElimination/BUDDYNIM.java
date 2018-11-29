package PreElimination;

import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class BUDDYNIM {

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
        int ca, cb, i, n, m, t = sc.nextInt();
        Integer a[], b[];
        while(t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            a = new Integer[n];
            ca = 0;
            for(i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                ca += a[i] == 0 ? 0 : 1;
            }
            b = new Integer[m];
            cb = 0;
            for(i = 0; i < m; i++) {
                b[i] = sc.nextInt();
                cb += b[i] == 0 ? 0 : 1;
            }
            if(ca != cb)
                System.out.println("Alice");
            else {
                Arrays.sort(a, Collections.reverseOrder());
                Arrays.sort(b, Collections.reverseOrder());
                for(i = 0; i < ca; i++){
                    if(a[i] != b[i])
                        break;
                }
                if(i < ca)
                    System.out.println("Alice");
                else
                    System.out.println("Bob");
            }
        }
    }
}