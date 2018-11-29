import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class MAXSC {

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
        long[][] d = new long[700][700];
        int i, j, n, t = sc.nextInt();
        long r, imx, mx;
        while(t-- > 0){
            n = sc.nextInt();
            for(i = 0; i < n; i++)
                for(j = 0; j < n; j++)
                    d[i][j] = sc.nextLong();
            mx = 1000000001;
            r = 0;
            for(i = n - 1; i >= 0; i--){
                imx = -1;
                for(j = 0; j < n; j++){
                    if(d[i][j] < mx && d[i][j] > imx)
                        imx = d[i][j];
                }
                if(imx == -1)
                    break;
                r += imx;
                mx = imx;
            }
            System.out.println(i > 0 ? -1 : r);
        }
    }
}
