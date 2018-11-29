import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MINVOTE {

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

    static int lower_bound(long a[], int ss, int se, long v){
        if(ss == se){
            if(a[ss] <= v)
                return ss;
            else
                return ss - 1;
        }
        int mid = (ss + se) / 2;
        if(a[mid] < v)
            return lower_bound(a, mid + 1, se, v);
        else
            return lower_bound(a, ss, mid, v);
    }

    static int upper_bound(long a[], int ss, int se, long v){
        if(ss == se){
            if(a[ss] <= v)
                return ss;
            else
                return ss + 1;
        }
        int mid = (ss + se) / 2;
        if(a[mid] < v)
            return upper_bound(a, ss, mid, v);
        else
            return upper_bound(a, mid + 1, se, v);
    }

    static long getSum(long BITree[], int index) {
        long sum = 0;
        index = index + 1;

        while(index > 0) {
            sum += BITree[index];
            index -= index & (-index);
        }
        return sum;
    }

    static void updateBIT(long BITree[], int n, int index, int val) {
        index = index + 1;

        while(index <= n) {
            BITree[index] += val;
            index += index & (-index);
        }
    }

    static void updateRange(long BITTree1[], long BITTree2[], int n, int val, int l, int r) {
        updateBIT(BITTree1, n, l, val);
        updateBIT(BITTree1, n,r + 1, -val);

        updateBIT(BITTree2, n, l,val * (l - 1));
        updateBIT(BITTree2, n,r + 1,-val * r);
    }

    static long sum(int x, long BITTree1[], long BITTree2[]) {
        return (getSum(BITTree1, x) * x) - getSum(BITTree2, x);
    }

    static long rangeSum(int l, int r, long BITTree1[], long BITTree2[]) {
        return sum(r, BITTree1, BITTree2) - sum(l - 1, BITTree1, BITTree2);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int k, n, t = sc.nextInt();
        int d[];
        long ac[], rac[], bitTree1[], bitTree2[];
        while(t-- > 0){
            n = 100000;//sc.nextInt();
            d = new int[n];
            for(int i = 0; i < n; i++)
                d[i] = (int)(Math.random() * 1000000000) + 1;//sc.nextInt();
            ac = new long[n];
            ac[0] = d[0];
            for(int i = 1; i < n; i++)
                ac[i] = ac[i - 1] + d[i];
            rac = new long[n];
            rac[n - 1] = d[n - 1];
            for(int i = n - 2; i >= 0; i--)
                rac[i] = rac[i + 1] + d[i];
            bitTree1 = new long[n + 1];
            bitTree2 = new long[n + 1];
            for(int i = 0; i < n - 1; i++) {
                k = lower_bound(ac, i + 1, n - 1, d[i] + ac[i]);
                updateRange(bitTree1, bitTree2, n, 1, i + 1, k < n - 1 ? (k + 1) : k);
            }
            for(int i = 1; i < n; i++) {
                k = upper_bound(rac, 0, i - 1, d[i] + rac[i]);
                updateRange(bitTree1, bitTree2, n, 1, k > 0 ? (k - 1) : k, i - 1);
            }
            long r[] = test(n, d);
            long _r;
            for(int i = 0; i < n; i++) {
                _r = rangeSum(i, i, bitTree1, bitTree2);
                //System.out.print(_r + " ");
                if(r[i] != _r)
                    System.out.println("error: " + r[i]);
            }
            //System.out.println();
        }
    }

    static long[] test(int n, int d[]){
        long r[] = new long[n];
        long s;
        for(int i = 0; i < n; i++){
            s = 0;
            for(int j = i + 1; j < n; j++){
                if(s <= d[i])
                    r[j]++;
                else
                    break;
                s += d[j];
            }
        }
        for(int i = n - 1; i >= 0; i--){
            s = 0;
            for(int j = i - 1; j >= 0; j--){
                if(s <= d[i])
                    r[j]++;
                else
                    break;
                s += d[j];
            }
        }
        return r;
    }
}
