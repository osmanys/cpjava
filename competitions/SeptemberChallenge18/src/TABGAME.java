import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TABGAME {

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
        int mz, nz, q, x, y, t = sc.nextInt();
        String m, n;
        boolean _m[][], _n[][];
        while (t-- > 0) {
            m = sc.next();
            n = sc.next();
            mz = m.length();
            nz = n.length();
            _m = new boolean[3][mz + 1];
            _n = new boolean[3][nz + 1];
            for (int i = 0; i < mz; i++)
                if (m.charAt(i) == '0')
                    _m[0][i] = true;
            for (int i = 0; i < nz; i++)
                if (n.charAt(i) == '0')
                    _n[0][i] = true;
            for (int l = 1; l <= 2; l++) {
                if (!_m[l - 1][l - 1] && !_n[l - 1][l - 1]) {
                    _m[l][l - 1] = true;
                    _n[l][l - 1] = true;
                }
                for (int i = l; i < mz; i++)
                    if (!_m[l - 1][i] && !_m[l][i - 1])
                        _m[l][i] = true;
                for (int i = l; i < nz; i++)
                    if (!_n[l - 1][i] && !_n[l][i - 1])
                        _n[l][i] = true;
            }
            q = sc.nextInt();
            while (q-- > 0) {
                x = sc.nextInt();
                y = sc.nextInt();
                if(x == y) {
                    if(x > 2){
                        y = 2;
                        x = 2;
                    }
                    System.out.print(_m[x - 1][y - 1] || _n[y - 1][x - 1] ? 1 : 0);
                }
                else if(x < y){
                    if(x > 2){
                        y -= x - 2;
                        x = 2;
                    }
                    System.out.print(_m[x - 1][y - 1] || _m[x][y - 2] ? 1 : 0);
                }
                else{
                    if(y > 2){
                        x -= y - 2;
                        y = 2;
                    }
                    System.out.print(_n[y - 1][x - 1] || _n[y][x - 2] ? 1 : 0);
                }
            }
        }
    }
}
