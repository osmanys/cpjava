import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        int n = sc.nextInt();
        long h = sc.nextLong();
        long[] a = new long[n];
        long[] b = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
            b[i] = sc.nextLong();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int ia = n - 1, ib = n - 1;
        long v, r = 0;
        while((ia >= 0 || ib >= 0) && h > 0){
            if(ia < 0){
                h -= b[ib];
                r++;
                ib--;
            }
            else if(ib < 0){
                v = h / a[ia] + (h % a[ia] != 0 ? 1 : 0);
                h -= v * a[ia];
                r += v;
                ia--;
            }
            else{
                if(a[ia] > b[ib]) {
                    v = h / a[ia] + (h % a[ia] != 0 ? 1 : 0);
                    h -= v * a[ia];
                    r += v;
                    ia--;
                }
                else {
                    h -= b[ib];
                    r++;
                    ib--;
                }
            }
        }
        System.out.println(r);
    }
}
