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
        int i, diff, r, n, k, t = 0, T = sc.nextInt();
        while(t++ < T){
            n = sc.nextInt();
            k = sc.nextInt();
            if(n == 2)
                r = 0;
            else {
                diff = (k - 1) * k / 2 - (n < k ? (k - n) * (k - n  + 1) / 2 : 0);
                if(diff > k)
                    r = diff - k;
                else
                    r = 0;
            }
            fw.write("Case #" + t + ": " + r + "\n");
            if(r == 0) {
                fw.write("1\n");
                fw.write("1 " + n + " 1\n");
            }
            else {
                fw.write((n >= k ? k : n) + "\n");
                fw.write("1 " + n + " " + k + "\n");
                for(i = 1; i < n - 1 && k - i > 1; i++)
                    fw.write(i + " " + (i + 1) + " " + (k - i) + "\n");
                fw.write(i + " " + n + " " + (k - i) + "\n");
            }
            fw.flush();
        }
    }
}
