import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class GMEDIAN {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        int c[][] = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j <= Math.min(i, 1000); j++) {
                if (j == 0 || j == i)
                    c[i][j] = 1;
                else
                    c[i][j] = (c[i - 1][j - 1] + c[i - 1][j]) % MOD;
            }
        }
        int d[][] = new int[1001][1001];
        for (int i = 0; i < 1001; i++)
            for (int j = i; j < 1001; j++){
                for (int k = 0; k <= i; k++)
                    d[i][j] = (d[i][j] + (int)((long)c[i][k] * c[j][k] % MOD)) % MOD;
                d[j][i] = d[i][j];
            }
        int pow[] = new int[1001];
        pow[0] = 1;
        for(int i = 1; i < 1001; i++)
            pow[i] = (2 * pow[i - 1]) % MOD;
        FastReader sc = new FastReader();
        int r, n, t = sc.nextInt();
        int a[];
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            Arrays.sort(a);
            r = pow[n - 1];
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++){
                    if(a[i] == a[j])
                        r = (r + d[i][n - j - 1]) % MOD;
                }
            System.out.println(r);
        }
    }
}
