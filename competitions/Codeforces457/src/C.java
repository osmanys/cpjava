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
        int i, j, n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(2 + " " + (n == 2 ? 2 : 100003));
        System.out.println("1 " + n + " 2");
        m--;
        if(n > 2){
            System.out.println("1 2" + " " + (100003 - n + 1));
            m--;
        }
        if(m > 0) {
            for (i = 1; i < n; i++) {
                for (j = i + 1; j <= n; j++) {
                    if (i != 1 || (j != 2 && j != n)) {
                        System.out.println(i + " " + j + " 1");
                        m--;
                        if (m == 0)
                            break;
                    }
                }
                if (j <= n)
                    break;
            }
        }
    }
}
