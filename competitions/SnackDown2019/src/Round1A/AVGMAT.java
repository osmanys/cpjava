package Round1A;

import java.io.*;
import java.util.*;

public class AVGMAT {

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

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int r[], res, sum, n, m, t = sc.nextInt();
        List<Point> points[];
        String l;
        while(t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            points = new List[n];
            for (int i = 0; i < n; i++) {
                points[i] = new ArrayList<>();
                l = sc.next();
                for (int j = 0; j < m; j++)
                    if (l.charAt(j) == '1')
                        points[i].add(new Point(i, j));
            }
            r = new int[n + m];
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    res = 0;
                    sum = 0;

                }
            }
            for(int i = 1; i <= n + m - 2; i++)
                System.out.print(r[i] + " ");
            System.out.println();
        }
    }
}
