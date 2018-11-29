import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFCHR {

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
        int r, t = sc.nextInt();
        String l;
        while(t-- > 0){
            l = sc.nextLine();
            if(l.length() < 4) {
                System.out.println("normal");
                continue;
            }
            r = 0;
            for(int i = 0; i < l.length() - 3; i++){
                if(l.charAt(i) == 'c' || l.charAt(i) == 'h' || l.charAt(i) == 'e' || l.charAt(i) == 'f')
                    if(l.charAt(i + 1) == 'c' || l.charAt(i + 1) == 'h' || l.charAt(i + 1) == 'e' || l.charAt(i + 1) == 'f')
                        if(l.charAt(i + 2) == 'c' || l.charAt(i + 2) == 'h' || l.charAt(i + 2) == 'e' || l.charAt(i + 2) == 'f')
                            if(l.charAt(i + 3) == 'c' || l.charAt(i + 3) == 'h' || l.charAt(i + 3) == 'e' || l.charAt(i + 3) == 'f')
                                if(l.charAt(i) != l.charAt(i + 1) && l.charAt(i) != l.charAt(i + 2) && l.charAt(i) != l.charAt(i + 3))
                                    if(l.charAt(i + 1) != l.charAt(i + 2) && l.charAt(i + 1) != l.charAt(i + 3))
                                        if(l.charAt(i + 2) != l.charAt(i + 3))
                                            r++;
            }
            if(r == 0)
                System.out.println("normal");
            else
                System.out.println("lovely " + r);
        }
    }
}
