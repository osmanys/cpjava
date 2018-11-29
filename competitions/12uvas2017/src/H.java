import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H {

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
        String l;
        StringTokenizer st;
        int mx, mn, g, r, n, i;
        long c, v;
        l = sc.nextLine();
        n = Integer.parseInt(l);
        while(n != 0){
            c = 1000000001;
            mn = 100001;
            mx = 0;
            st = new StringTokenizer(sc.nextLine());
            g = 0;
            r = 0;
            for(i = 0; i < n; i++){
                v = Long.parseLong(st.nextToken());
                if(c > v){
                    r++;
                    c = v;
                    if(g > 0 && g < mn)
                        mn = g;
                    if(g > 0 && g > mx)
                        mx = g;
                    g = 1;
                }
                else{
                    g++;
                }
            }
            if(g < mn)
                mn = g;
            if(g > mx)
                mx = g;
            System.out.printf("%d %d %d\n", r, mn, mx);
            l = sc.nextLine();
            n = Integer.parseInt(l);
        }
    }
}
