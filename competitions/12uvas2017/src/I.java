import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I {

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
        int d[] = new int[1000];
        String l;
        int i, c, r;
        while((l = sc.nextLine()) != null && l.length() > 0){
            c = 1;
            d[0] = 0;
            for(i = 0; i < l.length(); i++){
                if(l.charAt(i) != '.') {
                    d[c] = Character.getNumericValue(l.charAt(i));
                    c++;
                }
            }
            r = 1;
            for(i = c - 1; i >= 0; i--){
                if(d[i] == 9 && r == 1)
                    d[i] = 0;
                else{
                    d[i] += r;
                    r = 0;
                }
            }
            if(d[0] != 0)
                System.out.print(d[0]);
            for(i = 1; i < c; i++){
                if((c - i) % 3 == 0 && (i > 1 || d[0] != 0))
                    System.out.print(".");
                System.out.print(d[i]);
            }
            System.out.println();
        }
    }
}
