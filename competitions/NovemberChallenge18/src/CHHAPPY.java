import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class CHHAPPY {

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
        int i, n, t = sc.nextInt();
        int d[];
        Hashtable<Integer, Integer> idx;
        while(t-- > 0){
            idx = new Hashtable();
            n = sc.nextInt();
            d = new int[n];
            for(i = 0; i < n; i++)
                d[i] = sc.nextInt();
            for(i = 0; i < n; i++){
                if(idx.containsKey(d[d[i] - 1]) && idx.get(d[d[i] - 1]) != d[i])
                    break;
                idx.put(d[d[i] - 1], d[i]);
            }
            System.out.println(i < n ? "Truly Happy" : "Poor Chef");
        }
    }
}
