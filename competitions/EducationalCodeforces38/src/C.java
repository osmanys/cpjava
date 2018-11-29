import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int n, k, t = sc.nextInt();
        String s;
        long f[], ef[], hef[], chef[];
        while(t-- > 0){
            n = sc.nextInt();
            k = sc.nextInt();
            s = sc.nextLine();
            f = new long[n + 1];
            for(int i = n - 1; i >= 0; i++)
                f[i] = (s.charAt(n - 1) == 'f' ? 1 : 0) + f[i + 1];
            ef = new long[n + 1];
            for(int i = n - 1; i >= 0; i++)
                ef[i] = (s.charAt(n - 1) == 'e' ? 1 : 0) + f[i + 1] + ef[i + 1];
            hef = new long[n + 1];
            for(int i = n - 1; i >= 0; i++)
                hef[i] = (s.charAt(n - 1) == 'h' ? 1 : 0) + ef[i + 1] + hef[i + 1];
            chef = new long[n + 1];
            for(int i = n - 1; i >= 0; i++)
                chef[i] = (s.charAt(n - 1) == 'c' ? 1 : 0) + hef[i + 1] + chef[i + 1];
            if(chef[0] < k)
                System.out.println(-1);
            else if(chef[0] == k)
                System.out.println(0);
            else{

            }
        }
    }
}
