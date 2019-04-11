package training._2018.round1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

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
        int rlast, clast, cell, r, c, h, v, tc = sc.nextInt();
        int d[][];
        String line;
        boolean possible;
        boolean hacc[], racc[], chips[][];
        for(int t = 1; t <= tc; t++) {
            possible = true;
            r = sc.nextInt();
            c = sc.nextInt();
            h = sc.nextInt();
            v = sc.nextInt();
            d = new int[r][c];
            chips = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                line = sc.next();
                for (int j = 0; j < c; j++) {
                    if (line.charAt(j) == '@') {
                        d[i][j] = 1;
                        chips[i][j] = true;
                    }
                    if (i != 0)
                        d[i][j] += d[i - 1][j];
                    if (j != 0)
                        d[i][j] += d[i][j - 1];
                    if(i != 0 && j != 0)
                        d[i][j] -= d[i -1][j - 1];
                }
            }
            if(d[r - 1][c - 1] != 0) {
                if (d[r - 1][c - 1] % ((h + 1) * (v + 1)) == 0) {
                    cell = d[r - 1][c - 1] / ((h + 1) * (v + 1));
                    hacc = new boolean[r];
                    racc = new boolean[c];
                    rlast = -1;
                    for (int i = 0; i < r; i++) {
                        if(i == 0 || d[i][c - 1] != d[i - 1][c - 1]) {
                            if (d[i][c - 1] - (rlast == -1 ? 0 : d[rlast][c - 1]) == (v + 1) * cell) {
                                clast = -1;
                                for (int j = 0; j < c; j++) {
                                    if(j == 0 || chips[i][j]) {
                                        if (d[i][j] - (rlast == -1 ? 0 : d[rlast][j]) - (clast == -1 ? 0 : d[i][clast]) + (rlast == -1 || clast == -1 ? 0 : d[rlast][clast]) == cell) {
                                            clast = j;
                                        } else {
                                            racc[j] = true;
                                        }
                                    }
                                }
                                rlast = i;
                            } else {
                                hacc[i] = true;
                            }
                        }
                    }
                    for (int i = 0; i < r; i++) {
                        if (!hacc[i])
                            h--;
                    }
                    for (int j = 0; j < c; j++) {
                        if (!racc[j])
                            v--;
                    }
                    if (h != -1 || v != -1)
                        possible = false;
                } else {
                    possible = false;
                }
            }
            System.out.println("Case #" + t + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
        }
    }
}
