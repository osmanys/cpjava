import java.io.*;
import java.util.*;

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

    static class tuple {
        int index;
        long val;

        tuple(int index, long val){
            this.index = index;
            this.val = val;
        }
    }

    static class SegmentTreeRMQ
    {
        tuple st[];
        long lazy[];

        tuple maxVal(tuple x, tuple y) {
            if (x.val > y.val)
                return x;
            else if(x.val < y.val)
                return y;
            else if(x.index >= 0 && y.index >= 0 && x.index >= 0 && y.index >= 0 && iVal[x.index].peek().pos > iVal[y.index].peek().pos)
                return x;
            else
                return y;
        }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }

        tuple RMQUtil(int ss, int se, int qs, int qe, int index)
        {
            if (lazy[index] != 0) {
                st[index].val += lazy[index];
                if (ss != se) {
                    lazy[2 * index + 1] += lazy[index];
                    lazy[2 * index + 2] += lazy[index];
                }
                lazy[index] = 0;
            }
            if (qs <= ss && qe >= se)
                return st[index];
            if (se < qs || ss > qe)
                return new tuple(-1, Long.MIN_VALUE);
            int mid = getMid(ss, se);
            return maxVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                    RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
        }

        tuple RMQ(int n, int qs, int qe)
        {
            if (qs < 0 || qe > n - 1 || qs > qe) {
                return new tuple(-1, Long.MIN_VALUE);
            }
            return RMQUtil(0, n - 1, qs, qe, 0);
        }

        void updateRangeUtil(int ss, int se, int qs, int qe, int index, long delta)
        {
            if (ss > se)
                return;

            if (lazy[index] != 0) {
                st[index].val += lazy[index];
                if (ss != se) {
                    lazy[2 * index + 1] += lazy[index];
                    lazy[2 * index + 2] += lazy[index];
                }
                lazy[index] = 0;
            }

            if (se < qs || ss > qe)
                return;

            if (ss >= qs && se <= qe)
            {
                st[index].val += delta;
                if (ss != se)
                {
                    lazy[index * 2 + 1] += delta;
                    lazy[index * 2 + 2] += delta;
                }
                return;
            }
            int mid = getMid(ss, se);
            updateRangeUtil(ss, mid, qs, qe, index * 2 + 1, delta);
            updateRangeUtil(mid + 1, se, qs, qe, index * 2 + 2, delta);

            st[index] = maxVal(st[2 * index + 1], st[2 * index + 2]);
        }

        void updateRange(int n, int ss, int se, long delta)  {
            updateRangeUtil(0, n - 1, ss, se, 0, delta);
        }

        tuple constructSTUtil(long arr[], int ss, int se, int si)
        {
            if (ss == se) {
                st[si] = new tuple(ss, arr[ss]);
                return st[si];
            }
            int mid = getMid(ss, se);
            st[si] = maxVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                    constructSTUtil(arr, mid + 1, se, si * 2 + 2));
            return st[si];
        }

        void constructST(long arr[], int n)
        {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            st = new tuple[max_size];
            lazy = new long[max_size];
            constructSTUtil(arr, 0, n - 1, 0);
        }
    }

    static tuple farthest(int n, int x, SegmentTreeRMQ st, long ws[]) {
        tuple r1 = x == n - 1 ? new tuple(-1, Long.MIN_VALUE) : st.RMQ(n, x + 1, n - 1);
        long val1 = x == n - 1 ? Long.MIN_VALUE : (r1.val - ws[x]);
        tuple r2 = x == 0 ? new tuple(-1, Long.MIN_VALUE) : st.RMQ(n, 0, x - 1);
        long val2 = x == 0 ? Long.MIN_VALUE : (r2.val + ws[n] - ws[x]);
        long val3 = iVal[x].peek().val - ws[x];
        if (val1 > val2 || (val1 == val2 && r1.index > 0 && r2.index > 0 && iVal[r1.index].peek().pos > iVal[r2.index].peek().pos)) {
            if (val3 > val1 || (val3 == val1 && r1.index > 0 && iVal[x].peek().pos > iVal[r1.index].peek().pos))
                return new tuple(x, val3);
            else
                return new tuple(r1.index, val1);
        }
        else {
            if (val3 > val2 || (val3 == val2 && r2.index > 0 && iVal[x].peek().pos > iVal[r2.index].peek().pos))
                return new tuple(x, val3);
            else
                return new tuple(r2.index, val2);
        }
    }

    static class Nod {
        int pos;
        long val;

        public Nod(int pos, long val){
            this.pos = pos;
            this.val = val;
        }
    }

    static class NodComparator implements Comparator<Nod> {
        public int compare(Nod s1, Nod s2) {
            if (s1.val > s2.val || (s1.val == s2.val && s1.pos > s2.pos))
                return -1;
            else
                return 1;
        }
    }

    static long ws[];
    static PriorityQueue<Nod> iVal[];
    static SegmentTreeRMQ st;

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ws = new long[n + 1];
        iVal = new PriorityQueue[n];
        ws[1] = sc.nextLong();
        iVal[0] = new PriorityQueue<>(new NodComparator());
        iVal[0].add(new Nod(-1, 0L));
        for(int i = 1; i < n; i++) {
            ws[i + 1] = ws[i] + sc.nextLong();
            iVal[i] = new PriorityQueue<>(new NodComparator());
            iVal[i].add(new Nod(-1, 0L));
        }
        st = new SegmentTreeRMQ();
        st.constructST(ws, n);
        int f, x, t, m = sc.nextInt();
        long _old, _new, w;
        for(int i = 0; i < m; i++){
            t = sc.nextInt();
            if(t == 1){
                x = sc.nextInt() - 1;
                w = sc.nextLong();
                f = farthest(n, x, st, ws).index;
                _old = iVal[f].peek().val;
                iVal[f].add(new Nod(i, _old + w));
                st.updateRange(n, f, f, w);
            }
            else if(t == 2){
                x = sc.nextInt() - 1;
                w = sc.nextLong();
                _old = iVal[x].peek().val;
                iVal[x].add(new Nod(i, w));
                _new = iVal[x].peek().val;
                if(_new - _old != 0)
                    st.updateRange(n, x, x, _new - _old);
            }
            else if(t == 3){
                x = sc.nextInt() - 1;
                f = farthest(n, x, st, ws).index;
                _old = iVal[f].peek().val;
                iVal[f].remove();
                _new = iVal[f].peek().val;
                if(_new - _old != 0)
                    st.updateRange(n, f, f, _new - _old);
            }
            else if(t == 4){
                x = sc.nextInt() - 1;
                System.out.println(farthest(n, x, st, ws).val);
            }
        }
    }
}
