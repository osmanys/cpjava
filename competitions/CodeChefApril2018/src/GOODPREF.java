import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GOODPREF {

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
        int tmp, c, n, t = sc.nextInt();
        long r;
        String s;
        int d[];
        while(t-- > 0){
            s = sc.next();
            n = sc.nextInt();
            d = new int[s.length()];
            c = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'a')
                    c++;
                else
                    c--;
                d[i] = c;
            }
            r = 0;
            for(int i = 0; i < s.length(); i++) {
                if(d[i] >= 0 && c >= 0 && d[i] + c > 0)
                    r += n;
                else if(d[i] > 0 || c > 0){
                    tmp = (1 - d[i]) / c;
                    if (tmp < 0)
                        tmp = 0;
                    else if (tmp > n - 1)
                        tmp = n - 1;
                    r += n - tmp;
                }
            }
            System.out.println(r);
        }
    }
}
