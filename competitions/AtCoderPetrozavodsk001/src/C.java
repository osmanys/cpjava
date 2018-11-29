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
        int n = sc.nextInt();
        int c, ss = 0, se = n - 1;
        System.out.println(ss);
        System.out.flush();
        String l, ls = sc.nextLine();
        if(ls.equals("Vacant"))
            return;
        System.out.println(se);
        System.out.flush();
        String le = sc.nextLine();
        if(le.equals("Vacant"))
            return;
        do{
            c = (ss + se) / 2;
            System.out.println(c);
            System.out.flush();
            l = sc.nextLine();
            if(((c - ss) % 2 == 0 && ls.equals(l)) || ((c - ss) % 2 == 1 && !ls.equals(l))){
                ss = c;
                ls = l;
            }
            else{
                se = c;
                le = l;
            }
        }
        while(!l.equals("Vacant"));
    }
}
