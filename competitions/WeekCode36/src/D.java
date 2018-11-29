import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static class SegmentTreeRMQ {
        long data[];
        int ist[];

        int minVal(int x, int y) {
            if(x == -1)
                return y;
            if(y == -1)
                return x;
            return (data[x] < data[y]) ? x : y;
        }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }

        int RMQUtil(int ss, int se, int qs, int qe, int index) {
            if (qs <= ss && qe >= se)
                return ist[index];

            if (se < qs || ss > qe)
                return -1;

            int mid = getMid(ss, se);
            return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1), RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
        }

        int RMQ(int n, int qs, int qe) {
            return RMQUtil(0, n - 1, qs, qe, 0);
        }

        int updateSTUtil(int index, int ss, int se, int si){
            if (ss == se) {
                ist[si] = ss;
                return ss;
            }

            int mid = getMid(ss, se);
            if(index <= mid)
                updateSTUtil(index, ss, mid, si * 2 + 1);
            else
                updateSTUtil(index, mid + 1, se, si * 2 + 2);

            ist[si] = minVal(ist[si * 2 + 1], ist[si * 2 + 2]);
            return ist[si];
        }

        void updateST(long val, int index, int n){
            data[index] = val;

            updateSTUtil(index, 0, n - 1, 0);
        }

        int constructSTUtil(int ss, int se, int si) {
            if (ss == se) {
                ist[si] = ss;
                return ss;
            }

            int mid = getMid(ss, se);
            ist[si] = minVal(constructSTUtil(ss, mid, si * 2 + 1), constructSTUtil(mid + 1, se, si * 2 + 2));
            return ist[si];
        }

        void constructST(long arr[], int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            int max_size = 2 * (int) Math.pow(2, x) - 1;
            data = arr;
            ist = new int[max_size];

            constructSTUtil(0, n - 1, 0);
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int h[] = new int[n];
        int p[] = new int[n];
        int next[] = new int[n];
        h[0] = sc.nextInt();
        for(int i = 1; i < n; i++)
            h[i] = sc.nextInt();
        for(int i = 1; i < n; i++)
            p[i] = sc.nextInt();
        int q[] = new int[n];
        int c = 0;
        for(int i = 0; i < n; i++){
            while(c > 0){
                if(h[q[c - 1]] < h[i]) {
                    next[q[c - 1]] = i;
                    c--;
                }
                else
                    break;
            }
            q[c] = i;
            c++;
        }
        while(c > 0){
            next[q[c - 1]] = n;
            c--;
        }
        SegmentTreeRMQ tree = new SegmentTreeRMQ();
        tree.constructST(new long[n], n);

        long ac[] = new long[n];
        int mn;
        for(int i = n - 1; i >= 0; i--){
            if(next[i] == n)
                ac[i] = 0;
            else
                ac[i] = ac[next[i]] + 2 * h[next[i]] - h[i];
            if(i + 1 <= next[i] - 1){
                mn = tree.RMQ(n, i + 1, next[i] - 1);
                if(ac[i] > ac[mn] + h[i])
                    ac[i] = ac[mn] + h[i];
            }
            ac[i] += p[i] - h[i];
            tree.updateST(ac[i], i, n);
        }
        System.out.println(n + ac[0] + h[0]);
    }
}
