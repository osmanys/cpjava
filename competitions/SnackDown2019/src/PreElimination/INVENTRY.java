package PreElimination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class INVENTRY {

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
        int r, c, m[], shift, n, t = sc.nextInt();
        boolean a[];
        String s;
        while (t-- > 0) {
            n = sc.nextInt();
            s = sc.next();
            a = new boolean[n];
            m = new int[n];
            shift = 0;
            c = 0;
            for (int i = 0; i < n; i++)
                a[i] = s.charAt(i) == '#';
            for (int i = 0; i < n; i++) {
                m[i] = shift;
                if (a[i]) {
                    if(c != i)
                        shift++;
                    c++;
                }
                else {
                    if (shift > 0)
                        shift--;
                }
            }
            if(shift > 0)
                System.out.println(-1);
            else {
                r = 0;
                c = 0;
                for (int i = 0; i < n; i++) {
                    if (a[i]) {
                        if (c != i) {
                            r += 2 * m[i] + i - c;
                        }
                        c++;
                    }
                }
                System.out.println(r);
            }
        }
    }
}