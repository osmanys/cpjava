import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

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
        int r, n = sc.nextInt();
        for(int i = 0; i < n; i++){
            r = 0;
            for(int j = 0; j < 5 ; j++)
                r += sc.nextInt();
            if(r == 0)
                System.out.println("Beginner");
            else if(r == 1)
                System.out.println("Junior Developer");
            else if(r == 2)
                System.out.println("Middle Developer");
            else if(r == 3)
                System.out.println("Senior Developer");
            else if(r == 4)
                System.out.println("Hacker");
            else if(r == 5)
                System.out.println("Jeff Dean");
        }
    }
}
