import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

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
        int a, b, n, q = sc.nextInt();
        long ac;
        while(q-- > 0){
            n = sc.nextInt();
            ac = 0;
            for(int i = 0; i < n; i++){
                a = sc.nextInt();
                b = sc.nextInt();
                if(a < b + ac)
                    ac += b - a;
                else
                    ac = 0;
            }
            System.out.println(ac > 0 ? 1 : 0);
        }
    }
}
