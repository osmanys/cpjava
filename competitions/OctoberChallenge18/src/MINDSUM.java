import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MINDSUM {

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
        int m = 0, ds, r, t = sc.nextInt();
        long n, d;
        while(t-- > 0){
            n = sc.nextLong();
            d = sc.nextLong();
            ds = (int)(n % 9 == 0 ? 9 : n % 9);
            for(r = 1; r < 9; r++){
                for(m = 0; m < 9; m++) {
                    if (ds + m * d == r)
                        break;
                }
                if(m < 9)
                    break;
            }
            System.out.println(r == 9 ? "9 0" : r + " " + m);
        }
    }
}
