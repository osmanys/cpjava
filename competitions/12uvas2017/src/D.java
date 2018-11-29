import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

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
        int c[] = new int[127];
        int t, i;
        while((l = sc.nextLine()) != null && l.length() > 0){
            for(i = 0; i < 127; i++)
                c[i] = 0;
            for(i = 0; i < l.length(); i++)
                c[l.charAt(i)]++;
            t = 0;
            for(i = 'a'; i <= 'z'; i++)
                t += c[i];
            for(i = 'A'; i <= 'Z'; i++)
                t += c[i];
            if(c['!'] > t)
                System.out.println("ESGRITO");
            else
                System.out.println("escrito");
        }
    }
}
