import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {

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
        int hh, mm, ss, h, m, s, t = sc.nextInt();
        String l;
        while(t-- > 0){
            l = sc.nextLine();
            h = (l.charAt(0) - '0') * 10 + (l.charAt(1) - '0');
            m = (l.charAt(3) - '0') * 10 + (l.charAt(4) - '0');
            s = (l.charAt(6) - '0') * 10 + (l.charAt(7) - '0');
            if(s == 0)
                ss = 0;
            else{
                ss = 60 - s;
                m++;
                if(m == 60){
                    m = 0;
                    h++;
                }
            }
            if(m == 0)
                mm = 0;
            else{
                mm = 60 - m;
                h++;
            }
            hh = 24 - h;
            System.out.printf("%02d:%02d:%02d\n", hh, mm, ss);
        }
    }
}
