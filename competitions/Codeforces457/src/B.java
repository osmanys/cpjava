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
        long n = sc.nextLong();
        int k = sc.nextInt();
        int mid = 500000;
        int d[] = new int[2 * mid];
        int c = 0, mx = 0;
        long p = 1;
        while(n / p > 0){
            if((n / p) % 2 == 1){
                c++;
                d[mid + mx] = 1;
            }
            mx++;
            p *= 2;
        }
        if(c > k){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
            mx--;
            while(c < k){
                if(d[mid + mx] == 0){
                    mx--;
                    continue;
                }
                d[mid + mx]--;
                d[mid + mx - 1] += 2;
                c++;
            }
            for(int i = 0; c > 0; i++){
                if(d[mid + mx - i] == 0)
                    continue;
                for(int j = 0; j < d[mid + mx - i]; j++)
                    System.out.print((mx - i) + " ");
                c -= d[mid + mx - i];
            }
            System.out.println();
        }
    }
}
