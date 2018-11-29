import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int bi, bmx, mx, mn, n = sc.nextInt();
        int d[] = new int[n];
        String l;
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
        l = sc.nextLine();
        ArrayList<Integer> r = new ArrayList();
        for(int i = 0; i < n - 1; i++){
            if(l.charAt(i) == '0')
                r.add(i);
        }
        r.add(n - 1);
        bmx = 0;
        bi = 0;
        int i = 0;
        for(i = 0; i < r.size(); i++){
            mx = 0; mn = 200001;
            for(int j = bi; j <= r.get(i); j++){
                if(mx < d[j])
                    mx = d[j];
                if(mn > d[j])
                    mn = d[j];
            }
            if(bmx > mn){
                System.out.println("NO");
                break;
            }
            bmx = mx;
            bi = r.get(i) + 1;
        }
        if(i == r.size())
            System.out.println("YES");
    }
}
