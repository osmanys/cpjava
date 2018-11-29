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
        int n = sc.nextInt();
        int y = (int)(sc.nextLong() / 1000);
        int a, b = 0;
        for (a = 0; a <= n; a++){
            for(b = 0; b <= n; b++){
                if(a + b > n)
                    continue;
                if(10 * a + 5 * b + (n - a - b) == y)
                    break;
            }
            if(b <= n)
                break;
        }
        if(a > n)
            System.out.println("-1 -1 -1");
        else
            System.out.println(a + " " + b + " " + (n - a - b));
    }
}
