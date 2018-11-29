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
        String l;
        int c[] = new int[10];
        int i;
        while((l = sc.nextLine()) != null && l.length() > 0){
            for(i = 0; i < 10; i++)
                c[i] = 0;
            for(i = 0; i < l.length(); i++)
                c[Character.getNumericValue(l.charAt(i))]++;
            for(i = 1; i < 10; i++)
                if(c[i] != c[i - 1])
                    break;
            if(i == 10)
                System.out.println("subnormal");
            else
                System.out.println("no subnormal");
        }
    }
}
