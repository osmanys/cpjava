import java.io.*;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class PRITREE {

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
        int n = sc.nextInt();
        int v[] = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = sc.nextInt();
        Random rand = new Random();
        for (int i = 2; i <= n; i++)
            System.out.println((rand.nextInt(i - 1) + 1) + " " + i);
    }
}
