package Round1A;

import java.io.*;
import java.util.*;

public class AVGMAT2 {

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

    static void initialize(int r[], int n, int m) {

    }

    static void reduce(int r[], int n, int m, int x, int y) {

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int r[], n, m, t = sc.nextInt();
        String l;
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            r = new int[n + m];
            initialize(r, n, m);
            for (int i = 0; i < n; i++) {
                l = sc.next();
                for (int j = 0; j < m; j++) {
                    if (l.charAt(j) == '0')
                        reduce(r, n, m, i, j);
                }
            }
            for (int i = 1; i <= n + m - 2; i++)
                System.out.print(r[i] + " ");
            System.out.println();
        }
    }
}
