import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G {

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
        String tk;
        StringTokenizer st;
        int dd, tt, vv, i, t = sc.nextInt();
        while(t-- > 0){
            dd = -1;
            tt = -1;
            vv= -1;
            st = new StringTokenizer(sc.nextLine());
            tk = st.nextToken();
            if(tk.charAt(0) == 'D')
                dd = Integer.parseInt(tk.substring(2));
            if(tk.charAt(0) == 'T')
                tt = Integer.parseInt(tk.substring(2));
            if(tk.charAt(0) == 'V')
                vv = Integer.parseInt(tk.substring(2));
            tk = st.nextToken();
            if(tk.charAt(0) == 'D')
                dd = Integer.parseInt(tk.substring(2));
            if(tk.charAt(0) == 'T')
                tt = Integer.parseInt(tk.substring(2));
            if(tk.charAt(0) == 'V')
                vv = Integer.parseInt(tk.substring(2));
            if(dd == -1)
                System.out.printf("D=%d\n", vv * tt);
            else if(tt == -1)
                System.out.printf("T=%d\n", dd / vv);
            else
                System.out.printf("V=%d\n", dd / tt);
        }
    }
}
