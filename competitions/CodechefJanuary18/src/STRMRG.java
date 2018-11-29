import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class STRMRG {

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

    static int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int ica, icb, i, n, m, t = sc.nextInt();
        String sa, sb;
        char c;
        char[] ca = new char[5000];
        char[] cb = new char[5000];
        while(t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            sa = sc.nextLine();
            c = 0;
            ica = 0;
            for(i = 0; i < n; i++) {
                if (sa.charAt(i) != c) {
                    ca[ica] = sa.charAt(i);
                    c = ca[ica];
                    ica++;
                }
            }
            sb = sc.nextLine();
            c = 0;
            icb = 0;
            for(i = 0; i < m; i++) {
                if (sb.charAt(i) != c) {
                    cb[icb] = sb.charAt(i);
                    c = cb[icb];
                    icb++;
                }
            }
            System.out.println(ica + icb - lcs(ca, cb, ica, icb));
        }
    }
}
