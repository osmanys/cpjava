import java.io.*;
import java.util.*;

public class C {

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
        int cur, i, j, a, c = sc.nextInt();
        boolean m[][];
        for(int t = 1; t <= c; t++) {
            a = sc.nextInt();
            cur = 2;
            m = new boolean[1000][1000];
            do {
                System.out.println(cur + " 2");
                System.out.flush();
                i = sc.nextInt();
                j = sc.nextInt();
                if(i > 0 && j > 0){
                    m[j - 1][i - 1] = true;
                    if(m[0][cur - 2] && m[1][cur - 2] && m[2][cur - 2]){
                        cur++;
                        if(m[0][cur - 2] && m[1][cur - 2] && m[2][cur - 2]){
                            cur++;
                            if(m[0][cur - 2] && m[1][cur - 2] && m[2][cur - 2])
                                cur++;
                        }
                    }
                }
            }
            while(i > 0 && j > 0);
        }
    }
}
