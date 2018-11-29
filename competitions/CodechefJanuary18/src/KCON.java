import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class KCON {

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

    static long maxSubArraySum(long a[], int size) {
        long max_so_far = a[0];
        long curr_max = a[0];

        for (int i = 1; i < size; i++){
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        long[] d = new long[100000];
        int i, n, k, t = sc.nextInt();
        long total, mx, mx_ini, mx_end, sum_ini, sum_end;
        while(t-- > 0){
            n = sc.nextInt();
            k = sc.nextInt();
            total = 0;
            for(i = 0; i < n; i++) {
                d[i] = sc.nextLong();
                total += d[i];
            }
            mx = maxSubArraySum(d, n);
            mx_ini = sum_ini = d[0];
            mx_end = sum_end = d[n - 1];
            for(i = 1; i < n; i++) {
                sum_ini += d[i];
                if(sum_ini > mx_ini)
                    mx_ini = sum_ini;
                sum_end += d[n - i - 1];
                if(sum_end > mx_end)
                    mx_end = sum_end;
            }
            if(k == 1)
                System.out.println(mx);
            else if(k == 2)
                System.out.println(Math.max(Math.max(mx, mx_ini + mx_end), total + Math.max(mx_ini, mx_end)));
            else
                System.out.println(Math.max(Math.max(mx, mx_ini + mx_end), (k - 2) * total + mx_ini + mx_end));
        }
    }
}
