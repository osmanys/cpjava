import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XXOR {

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

    static int getSum(int BITree[], int index) {
        int sum = 0;
        index = index + 1;

        while(index > 0) {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }

    static void updateBIT(int BITree[], int n, int index, int val) {
        index = index + 1;

        while(index <= n) {
            BITree[index] += val;
            index += index & (-index);
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int res, p, c, d, l, r, n = sc.nextInt();
        int q = sc.nextInt();
        int bitree[][] = new int[32][n + 1];
        for(int i = 0; i < n; i++) {
            d = sc.nextInt();
            for(int k = 0; k < 31; k++){
                if(d % 2 == 1)
                    updateBIT(bitree[k], n, i, 1);
                d /= 2;
            }
        }
        while(q-- > 0){
            l = sc.nextInt();
            r = sc.nextInt();
            p = 1;
            res = 0;
            for(int i = 0; i < 31; i++) {
                c = getSum(bitree[i], r - 1);
                if(l > 1)
                    c -= getSum(bitree[i], l - 2);
                if(2 * c < r - l + 1)
                    res += p;
                p *= 2;
            }
            System.out.println(res);
        }
    }
}
