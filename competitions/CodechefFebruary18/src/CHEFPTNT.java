import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFPTNT {

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
        int o, e, n, m, x , k, t = sc.nextInt();
        String l;
        while(t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            x = sc.nextInt();
            k = sc.nextInt();
            l = sc.nextLine();
            o = 0;
            e = 0;
            for(int i = 0; i < k; i++) {
                if (l.charAt(i) == 'E')
                    e++;
                else
                    o++;
            }
            if(((m / 2 + m % 2) * x < o ? (m / 2 + m % 2) * x : o) + ((m / 2) * x < e ? (m / 2) * x : e) >= n)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
