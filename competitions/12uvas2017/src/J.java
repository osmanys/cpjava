import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J {

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
        StringTokenizer st;
        int d, k, n, i, s, c, m, mx;
        st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        while(n > 0 || k > 0){
            s = 0;
            c = 0;
            m = 0;
            mx = 0;
            st = new StringTokenizer(sc.nextLine());
            for(i = 0; i < n; i++){
                d = Integer.parseInt(st.nextToken());
                if(d == 0){
                    if(s == 1)
                        c++;
                }
                else{
                    if(s == 0){
                        m = 1;
                        s = 1;
                        c = 0;
                    }
                    else{
                        if(c <= k)
                            m += c + 1;
                        else{
                            if(mx < m)
                                mx = m;
                            m = 1;
                        }
                        c = 0;
                    }
                }
            }
            if(mx < m)
                mx = m;
            System.out.println(mx);
            st = new StringTokenizer(sc.nextLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        }
    }
}
