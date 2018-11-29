package Qualification;

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

    public static void main (String[] args) throws IOException {
        File f = new File("output.txt");
        FileWriter fw = new FileWriter(f);
        FastReader sc = new FastReader("input.txt");
        int n, k, t = 0, T = sc.nextInt();
        long v;
        String d[];
        while(t++ < T){
            n = sc.nextInt();
            k = sc.nextInt();
            v = sc.nextLong();
            d = new String[n];
            for(int i = 0; i < n; i++)
                d[i] = sc.next();
            String res2 = "";
            int i = 0;
            for(; i < k && ((v - 1) * k + i) % n > 0; i++)
                res2 += d[(int) (((v - 1) * k + i) % n)] + " ";
            String res1 = "";
            for(; i < k; i++)
                res1 += d[(int) (((v - 1) * k + i) % n)] + " ";

            fw.write("Case #" + t + ": " + (res1 + res2).trim() + "\n");
            fw.flush();
        }
    }
}
