package Round1;

import java.io.*;
import java.util.*;

public class SolutionA {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String inputFile) throws IOException
        {
            FileInputStream fis = new FileInputStream(inputFile);
            DataInputStream in = new DataInputStream(fis);

            br = new BufferedReader(new
                    InputStreamReader(in));
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

    final static int MOD = 1000000007;

    public static void main (String[] args) throws IOException {
        File f = new File("output.txt");
        FileWriter fw = new FileWriter(f);
        FastReader sc = new FastReader("input.txt");
        int n, t = 0, T = sc.nextInt();
        String s[] = new String[3];
        int res[][][];
        while(t++ < T){
            n = sc.nextInt();
            s[0] = sc.next();
            s[1] = sc.next();
            s[2] = sc.next();
            res = new int[3][n][4];
            if(s[0].charAt(0) != '#' && s[1].charAt(0) != '#') {
                res[0][0][3] = 1;
                res[1][0][1] = 1;
            }
            for(int i = 1; i < n; i++){
                if(i % 2 == 1) {
                    if (s[1].charAt(i) != '#') {
                        res[1][i][0] = (res[1][i - 1][1] + res[1][i - 1][2]) % MOD;
                        res[1][i][3] = (res[1][i - 1][1] + res[1][i - 1][2]) % MOD;
                    }
                    if (s[0].charAt(i) != '#')
                        res[0][i][2] = res[1][i][0];
                    if (s[2].charAt(i) != '#')
                        res[2][i][1] = res[1][i][3];
                }
                else {
                    if (s[0].charAt(i) != '#')
                        res[0][i][3] = res[0][i - 1][2];
                    if (s[2].charAt(i) != '#')
                        res[2][i][0] = res[2][i - 1][1];
                    if (s[1].charAt(i) != '#') {
                        res[1][i][1] = res[0][i][3];
                        res[1][i][2] = res[2][i][0];
                    }
                }
            }
            fw.write("Case #" + t + ": " + res[2][n - 1][1] + "\n");
            fw.flush();
        }
    }
}
