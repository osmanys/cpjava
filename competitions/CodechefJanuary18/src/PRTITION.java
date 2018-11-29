import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PRTITION {

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
        int[] b = new int[1000001];
        int i, x, n, t = sc.nextInt();
        long r;
        while(t-- > 0){
            x = sc.nextInt();
            n = sc.nextInt();
            r = 1L * n * (n + 1) / 2 - x;
            if(r % 2 == 1)
                System.out.println("impossible");
            else {
                r /= 2;
                for (i = n; i > 0; i--) {
                    if(i == x)
                        b[i] = 2;
                    else if(i > r || (r - i == x && x <= 2))
                        b[i] = 0;
                    else {
                        b[i] = 1;
                        r -= i;
                    }
                }
                if(r > 0)
                    System.out.println("impossible");
                else {
                    for (i = 1; i <= n; i++)
                        System.out.print(b[i]);
                    System.out.println();
                }
            }
        }
    }
}
