import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int l, r, s, n, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            s = 1;
            for(int i = 0; i < n; i++){
                l = sc.nextInt();
                r = sc.nextInt();
                if(r < s) {
                    System.out.print("0 ");
                    continue;
                }
                if(l <= s) {
                    System.out.print(s + " ");
                    s++;
                }
                else {
                    System.out.print(l + " ");
                    s = l + 1;
                }
            }
            System.out.println();
        }
    }
}
