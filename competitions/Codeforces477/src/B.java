import java.io.*;
import java.util.*;

public class B {

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
        int i, n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int s[] = new int[n - 1];
        int s0 = sc.nextInt();
        long T = s0;
        for(i = 0; i < n - 1; i++) {
            s[i] = sc.nextInt();
            T += s[i];
        }
        Arrays.sort(s);
        for(i = n - 2; i >= 0 && (s0 * A < T * B); i--){
            T -= s[i];
        }
        System.out.println(n - i - 2);
    }
}
