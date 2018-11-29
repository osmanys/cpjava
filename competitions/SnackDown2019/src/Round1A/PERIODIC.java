package Round1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PERIODIC {

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
        int k, d[], n, t = sc.nextInt();
        ArrayList<Integer> blist;
        while (t-- > 0) {
            n = sc.nextInt();
            blist = new ArrayList<>();
            d = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = sc.nextInt();
                if (d[i] != -1 && (blist.isEmpty() || blist.get(blist.size() - 1) != i - d[i]))
                    blist.add(i - d[i]);
            }
            if (blist.size() <= 1)
                System.out.println("inf");
            else {
                k = -1;
                for (int i = 1; i < blist.size(); i++) {
                    if (blist.get(i) < blist.get(i - 1)) {
                        k = -1;
                        break;
                    }
                    if (k == -1)
                        k = blist.get(i) - blist.get(i - 1);
                    else {
                        if (blist.get(i) - blist.get(i - 1) > k && (blist.get(i) - blist.get(i - 1)) % k != 0) {
                            k = -1;
                            break;
                        } else if (blist.get(i) - blist.get(i - 1) < k && k % (blist.get(i) - blist.get(i - 1)) != 0) {
                            k = -1;
                            break;
                        } else if (blist.get(i) - blist.get(i - 1) < k) {
                            k = blist.get(i) - blist.get(i - 1);
                        }
                    }
                }
                if (k == -1)
                    System.out.println("impossible");
                else {
                    for(int i = 0; i < n; i++)
                        if(d[i] != -1 && d[i] != ((i + k - blist.get(0) - 1) % k) + 1) {
                            k = -1;
                            break;
                        }
                    System.out.println(k == -1 ? "impossible" : k);
                }
            }
        }
    }
}
