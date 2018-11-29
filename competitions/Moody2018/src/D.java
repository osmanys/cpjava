import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int a, m;
        int p[][][] = new int[101][101][101];
        for (m = 0; m < 101; m++)
            for (int l = 0; l < 101; l++)
                p[0][m][l] = 1;
        for (a = 1; a < 101; a++)
            for (m = 1; m < 101; m++)
                for (int l = 0; l <= a; l++)
                    for(int k = 0; k <= l; k++)
                        p[a][m][l] += p[a - k][m - 1][k == 0 ? 0 : k - 1];
        int q = sc.nextInt();
        while (q-- > 0) {
            a = sc.nextInt();
            m = sc.nextInt();
            System.out.println(p[a][m][a]);
        }
    }
}
