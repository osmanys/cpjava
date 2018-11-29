import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

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
        if(n <= 2)
            System.out.println("No");
        else {
            System.out.println("Yes");
            if(n % 2 == 1){
                System.out.println("1 " + n);
                System.out.print((n - 1) + " ");
                for(int i = 1; i < n; i++)
                    System.out.print(i + " ");
            }
            else{
                System.out.println("2 1 " + n);
                System.out.print((n - 2) + " ");
                for(int i = 2; i < n; i++)
                    System.out.print(i + " ");
            }
        }
    }
}
