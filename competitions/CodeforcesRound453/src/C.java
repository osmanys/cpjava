import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int h = sc.nextInt();
        int d[] = new int[h + 1];
        int n = 0;
        for (int i = 0; i <= h; i++) {
            d[i] = sc.nextInt();
            n += d[i];
        }
        int r[] = new int[n];
        int j, c = 1, p = 1;
        for (int i = 1; i <= h; i++) {
            j = 0;
            for(; j < d[i]; j++)
                r[c + j] = p;
            p = c + 1;
            c += j;
        }
        int r1[] = new int[n];
        boolean perf = true;
        c = 1;
        p = 1;
        for (int i = 1; i <= h; i++) {
            j = 0;
            for(; j < d[i]; j++) {
                r1[c + j] = (perf && d[i - 1] > 1 && d[i] > 1 && j == 0) ? p + 1 : p;
            }
            if(perf && d[i - 1] > 1 && d[i] > 1)
                perf = false;
            p = c + 1;
            c += j;
        }
        if(perf)
            System.out.println("perfect");
        else{
            System.out.println("ambiguous");
            for(int i = 0; i < n; i++)
                System.out.print(r[i] + " ");
            System.out.println();
            for(int i = 0; i < n; i++)
                System.out.print(r1[i] + " ");
        }
    }
}