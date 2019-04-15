package round1a;

import java.io.*;
import java.util.*;

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
        int r, c, tc = sc.nextInt();
        boolean reverse, possible;
        int[][] mov= new int[0][0];
        for(int t = 1; t <= tc; t++) {
            r = sc.nextInt();
            c = sc.nextInt();
            if(r > c){
                int tmp = r;
                r = c;
                c = tmp;
                reverse = true;
            }
            else
                reverse = false;
            possible = false;
            if(r == 2 && c == 5){
                possible = true;
                mov = new int[][]{{2, 1}, {1, 3}, {2, 5}, {1, 2}, {2, 4}, {1, 1}, {2, 3}, {1, 5}, {2, 2}, {1, 4}};
            }
            else if(r == 3 && c == 4){
                possible = true;
                mov = new int[][]{{3, 1}, {1, 2}, {3, 3}, {1, 4}, {2, 2}, {3, 4}, {2, 1}, {1, 3}, {3, 2}, {2, 4}, {1, 1}, {2, 3}};
            }
            else if(r == 3 && c == 5){
                possible = true;
                mov = new int[][]{{3, 1}, {1, 2}, {2, 4}, {3, 2}, {1, 3}, {2, 1}, {3, 5}, {2, 3}, {1, 5}, {3, 4}, {2, 2}, {1, 4}, {3, 3}, {2, 5}, {1, 1}};
            }
            else if(r == 4 && c == 4){
                possible = true;
                mov = new int[][]{{4, 1}, {3, 3}, {1, 2}, {2, 4}, {4, 3}, {3, 1}, {2, 3}, {4, 4}, {3, 2}, {1, 3}, {3, 4}, {2, 2}, {1, 4}, {2, 1}, {4, 2}, {1, 1}};
            }
            else if(r == 4 && c == 5){
                possible = true;
                mov = new int[][]{{4, 1}, {3, 3}, {1, 2}, {2, 4}, {4, 5}, {1, 4}, {2, 2}, {4, 3}, {3, 5}, {2, 3}, {1, 5}, {3, 4}, {4, 2}, {2, 1}, {1, 3}, {3, 2}, {1, 1}, {2, 5}, {3, 1}, {4, 4}};
            }
            else if(r == 5 && c == 5){
                possible = true;
                mov = new int[][]{{5, 1}, {3, 2}, {1, 3}, {3, 4}, {2, 2}, {4, 3}, {5, 5}, {2, 4}, {1, 2}, {3, 1}, {5, 2}, {4, 4}, {2, 5}, {3, 3}, {1, 4}, {2, 1}, {4, 2}, {5, 4}, {3, 5}, {2, 3}, {1, 5}, {1, 1}, {4, 5}, {5, 3}, {4, 1}};
            }
            if(possible){
                System.out.println("Case #" + t + ": POSSIBLE");
                for(int i = 0; i < r * c; i++) {
                    if (reverse)
                        System.out.println(mov[i][1] + " " + mov[i][0]);
                    else
                        System.out.println(mov[i][0] + " " + mov[i][1]);
                }
            }
            else{
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}
