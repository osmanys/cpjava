import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F {

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
        String l;
        StringTokenizer st;
        Double m, n;
        int i;
        while((l = sc.nextLine()) != null && l.length() > 0){
            st = new StringTokenizer(l);
            m = Double.parseDouble(st.nextToken());
            n = Double.parseDouble(st.nextToken()) * 1000000L;
            //System.out.println((int)Math.log(n / m) + 1);
            i = 0;
            while(m <= n){
                m = 2 * m;
                i++;
            }
            System.out.println(i);
        }
    }
}
