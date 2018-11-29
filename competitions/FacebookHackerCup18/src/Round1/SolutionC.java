package Round1;

import java.io.*;
import java.util.*;

public class SolutionC {

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

    public static void main (String[] args) throws IOException {
        File f = new File("output.txt");
        FileWriter fw = new FileWriter(f);
        FastReader sc = new FastReader("input.txt");
        int minj[], h[], a[], b[], u[], d[], w, x, y, z, n, m, t = 0, T = sc.nextInt();
        while(t++ < T){
            n = sc.nextInt();
            m = sc.nextInt();
            h = new int[n];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            w = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            for(int i = 3; i < n; i++)
                h[i] = (int)((1L * w * h[i - 2] + 1L * x * h[i - 1] + y) % z);
            a = new int[m];
            b = new int[m];
            u = new int[m];
            d = new int[m];
            for(int i = 0; i < m; i++){
                a[i] = sc.nextInt();
                b[i] = sc.nextInt();
                u[i] = sc.nextInt();
                d[i] = sc.nextInt();
            }
            minj = new int[n];
            for(int i = 0; i < n; i++){
                minj[i] = Integer.MAX_VALUE;
                for(int j = 0; j < m; j++){
                    //if(a[j] < b[j] && a[j] < i)
                }
            }

            String res = "";
            fw.write("Case #" + t + ": " + res.trim() + "\n");
            fw.flush();
        }
    }
}
