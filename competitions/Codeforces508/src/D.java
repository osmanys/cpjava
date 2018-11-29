import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int n = sc.nextInt();
        long sumneg = 0, maxneg = Long.MIN_VALUE;
        long sumpos = 0, minpos = Long.MAX_VALUE;
        long d;
        boolean haszero = false;
        for(int i = 0; i < n; i++){
            d = sc.nextLong();
            if(d == 0)
                haszero = true;
            else if(d < 0){
                sumneg += d;
                if(maxneg < d)
                    maxneg = d;
            }
            else{
                sumpos += d;
                if(minpos > d)
                    minpos = d;
            }
        }
        if((sumneg > 0 && sumpos > 0) || haszero)
            System.out.println(sumpos - sumneg);
        else if(sumpos > 0)
            System.out.println(n == 1 ? sumpos : (sumpos - 2 * minpos));
        else
            System.out.println(n == 1 ? sumneg : (2 * maxneg - sumneg));
    }
}
