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
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        long r2 = 0, r1 = 0;
        for(int i = 0; i < n; i++){
            if(a[i] > b[i])
                r1 += a[i] - b[i];
            else{
                r2 += (b[i] - a[i]) / 2;
                if((b[i] - a[i]) % 2 == 1){
                    r2++;
                    r1++;
                }
            }
        }
        if(r2 >= r1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
