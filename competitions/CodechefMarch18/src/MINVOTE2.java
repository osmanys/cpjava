import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MINVOTE2 {

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
        int n, t = sc.nextInt();
        int d[];
        long s, r[];
        while(t-- > 0){
            n = sc.nextInt();
            d = new int[n];
            for(int i = 0; i < n; i++)
                d[i] = sc.nextInt();
            r = new long[n];
            for(int i = 0; i < n; i++){
                s = 0;
                for(int j = i + 1; j < n; j++){
                    if(s > d[i])
                        break;
                    r[j]++;
                    s += d[j];
                }
            }
            for(int i = n - 1; i >= 0; i--){
                s = 0;
                for(int j = i - 1; j >= 0; j--){
                    if(s > d[i])
                        break;
                    r[j]++;
                    s += d[j];
                }
            }
            for(int i = 0; i < n; i++)
                System.out.print(r[i] + " ");
            System.out.println();
        }
    }
}
