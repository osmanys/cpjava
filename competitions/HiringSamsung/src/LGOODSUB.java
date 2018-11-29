import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LGOODSUB {

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
        int r, i, j, d, k, sq, n, t = sc.nextInt();
        int a[], min[], max[];
        while(t-- > 0){
            n = sc.nextInt();
            a = new int[n];
            for (i = 0; i < n; i++)
                a[i] = sc.nextInt();
            sq = (int)Math.sqrt(n);
            min = new int[sq];
            max = new int[sq];
            for(i = 0; i < sq; i++){
                min[i] = 1000000001;
                max[i] = 0;
                for(j = i * sq; i == sq - 1 ? j < n : j < (i + 1) * sq; j++){
                    if(min[i] > a[j])
                        min[i] = a[j];
                    if(max[i] < a[j])
                        max[i] = a[j];
                }
            }
            for(d = sq - 1; d > 0; d--){
                for(k = 0; k + d < sq; k++){
                    if(max[k] >= min[k + d])
                        break;
                }
                if(k + d < sq)
                    break;
            }
            r = 1;
            for(int _d = 0; _d < 2 && d >= 0; _d++, d--) {
                for (k = 0; k + d < sq; k++) {
                    for (i = k * sq; k == sq - 1 ? i < n : i < (k + 1) * sq; i++) {
                        for (j = (k + d) * sq; k + d == sq - 1 ? j < n : j < (k + d + 1) * sq; j++) {
                            if (a[i] >= a[j] && r < j - i + 1)
                                r = j - i + 1;
                        }
                    }
                }
            }
            System.out.println(r);
        }
    }
}
