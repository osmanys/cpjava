import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class PRDRG {

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

    static long gcd(long a, long b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long[][] build(){
        long gcd, r[][] = new long[27][2];
        r[0][0] = 1;
        r[0][1] = 1;
        r[1][0] = 0;
        r[1][1] = 1;
        for(int i = 2; i < 27; i++){
            r[i][0] = r[i - 1][0] * r[i - 2][1] + r[i - 2][0] * r[i - 1][1];
            r[i][1] = 2 * r[i - 1][1] * r[i - 2][1];

            gcd = gcd(r[i][0], r[i][1]);
            r[i][0] /= gcd;
            r[i][1] /= gcd;
        }
        return r;
    }

    public static void main (String[] args) {
        long r[][] = build();
        FastReader sc = new FastReader();
        int n, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            System.out.print(r[n + 1][0] + " " + r[n + 1][1] + " ");
        }
    }
}
