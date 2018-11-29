import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class MAGICHF2 {

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

    static double calc(long n, int k) {
        if (k == 0)
            return 1.0 / n;
        else if (n == 1 || n == 2)
            return 1;
        else {
            return calc(n - n / 2, k - 1);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int k, t = sc.nextInt();
        long n;
        for (int i = 0; i < t; i++) {
            n = sc.nextLong();
            k = sc.nextInt();
            if (k == 0)
                System.out.println(1.0 / n);
            else if (n == 2)
                System.out.println(0.5);
            else
                System.out.println(calc(n / 2 + (n % 4 == 0 ? 0 : 1), k - 1));
        }
    }
}
