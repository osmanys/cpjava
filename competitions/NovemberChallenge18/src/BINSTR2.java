import java.io.*;
import java.math.BigInteger;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class BINSTR2 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Max {
        int index;
        BigInteger value;

        Max(int index, BigInteger value) {
            this.index = index;
            this.value = value;
        }
    }

    static final int ALPHABET_SIZE = 2;

    static class TrieNode {
        TrieNode[] children;
        int index;

        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
        }
    }

    static class Trie {
        int length;
        TrieNode root;

        Trie() {
            length = 0;
            root = new TrieNode();
        }

        void insert(String key, int idx) {
            int index, level, keylength = key.length();

            TrieNode pCrawl, rootCrawl;
            if (length > 0 && keylength > length) {
                rootCrawl = pCrawl = new TrieNode();
                for (level = 1; level < keylength - length; level++) {
                    pCrawl.children[0] = new TrieNode();
                    pCrawl = pCrawl.children[0];
                }
                pCrawl.children[0] = root;
                root = rootCrawl;
                length = keylength;
            }

            pCrawl = root;
            if (keylength < length) {
                for (level = 0; level < length - keylength; level++) {
                    if (pCrawl.children[0] == null)
                        pCrawl.children[0] = new TrieNode();
                    pCrawl = pCrawl.children[0];
                }
            }

            for (level = 0; level < keylength; level++) {
                index = key.charAt(level) - '0';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();
                pCrawl = pCrawl.children[index];
            }
            pCrawl.index = idx;
            if (length == 0)
                length = keylength;
        }

        Max searchMaxXor(String key) {
            int shiftKey, next, index, level, keylength = key.length();

            BigInteger max = BigInteger.ZERO;
            TrieNode pCrawl = root;

            level = 0;
            if (keylength > length) {
                for (; level < keylength - length; level++) {
                    max = max.shiftLeft(1);
                    if(key.charAt(level) == '1')
                        max = max.add(BigInteger.ONE);
                }
                level = 0;
            } else if (keylength < length) {
                for (; level < length - keylength; level++) {
                    if (pCrawl.children[1] != null) {
                        max = max.shiftLeft(1).add(BigInteger.ONE);
                        pCrawl = pCrawl.children[1];
                    } else {
                        max = max.shiftLeft(1);
                        pCrawl = pCrawl.children[0];
                    }
                }
            }

            for (; level < length; level++) {
                shiftKey = keylength - length;
                index = key.charAt(shiftKey + level) - '0';
                if ((index == 0 && pCrawl.children[1] != null) || (index == 1 && pCrawl.children[0] != null)) {
                    next = index == 0 ? 1 : 0;
                    max = max.shiftLeft(1).add(BigInteger.ONE);
                } else {
                    next = index;
                    max = max.shiftLeft(1);
                }
                pCrawl = pCrawl.children[next];
            }
            return new Max(pCrawl.index, max);
        }

        void merge(Trie t) {
            int level;
            TrieNode rootCrawl, rCrawl = t.root;
            if (length < t.length) {
                rootCrawl = rCrawl = new TrieNode();
                for (level = 1; level < t.length - length; level++) {
                    rCrawl.children[0] = new TrieNode();
                    rCrawl = rCrawl.children[0];
                }
                rCrawl.children[0] = root;
                root = rootCrawl;
                length = t.length;
                rCrawl = t.root;
            } else if (length > t.length) {
                rCrawl = t.root;
                for (level = 0; level < length - t.length; level++) {
                    rCrawl = rCrawl.children[0];
                    if (rCrawl == null)
                        break;
                }
            }
            if (rCrawl != null)
                merge(root, rCrawl);
        }

        void merge(TrieNode t1, TrieNode t2) {
            if(t1.index > t2.index)
                t1.index = t2.index;
            if(t2.children[0] != null){
                if(t1.children[0] == null)
                    t1.children[0] = new TrieNode();
                merge(t1.children[0], t2.children[0]);
            }
            if(t2.children[1] != null){
                if(t1.children[1] == null)
                    t1.children[1] = new TrieNode();
                merge(t1.children[1], t2.children[1]);
            }
        }

        Trie copy() {
            Trie copy = new Trie();
            copy.length = length;
            copy.root = copy(root);
            return copy;
        }

        TrieNode copy(TrieNode t) {
            TrieNode copy = new TrieNode();
            copy.index = t.index;
            if (t.children[0] != null)
                copy.children[0] = copy(t.children[0]);
            if (t.children[1] != null)
                copy.children[1] = copy(t.children[1]);
            return copy;
        }
    }

    static class SegmentTree {
        Trie st[];

        SegmentTree(String arr[], int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            st = new Trie[max_size];
            for(int i = 0; i < max_size; i++)
                st[i] = new Trie();
            //constructSTUtil(arr, 0, n - 1, 0);
            for (int i = n - 1; i >= 0; i--)
                updateValueUtil(0, n - 1, i, arr[i], 0);
        }

        int getMid(int s, int e) {
            return s + (e - s) / 2;
        }

        void updateValueUtil(int ss, int se, int i, String str, int si) {
            if (i < ss || i > se)
                return;

            st[si].insert(str, i);
            if (se != ss) {
                int mid = getMid(ss, se);
                updateValueUtil(ss, mid, i, str, 2 * si + 1);
                updateValueUtil(mid + 1, se, i, str, 2 * si + 2);
            }
        }

        Trie constructSTUtil(String arr[], int ss, int se, int si) {
            if (ss == se) {
                st[si] = new Trie();
                st[si].insert(arr[ss], ss);
                return st[si];
            }

            int mid = getMid(ss, se);
            st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1).copy();
            Trie t = constructSTUtil(arr, mid + 1, se, si * 2 + 2);
            st[si].merge(t);
            return st[si];
        }

        int getMaxXor(int n, int qs, int qe, String key) {
            if (qs < 0 || qe > n - 1 || qs > qe)
                return -1;
            Max m = getMaxXorUtil(0, n - 1, qs, qe, 0, key);
            return m.index;
        }

        Max getMaxXorUtil(int ss, int se, int qs, int qe, int si, String key) {
            if (qs <= ss && qe >= se)
                return st[si].searchMaxXor(key);

            if (se < qs || ss > qe)
                return new Max(-1, BigInteger.ZERO);

            int mid = getMid(ss, se);
            Max m1 = getMaxXorUtil(ss, mid, qs, qe, 2 * si + 1, key);
            Max m2 = getMaxXorUtil(mid + 1, se, qs, qe, 2 * si + 2, key);

            return m2.value.compareTo(m1.value) == -1 ? m2 : m1;
        }
    }

    public static String removeZero(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;

        StringBuffer sb = new StringBuffer(str);
        sb.replace(0, i, "");

        return sb.toString();
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int res2, res, l, r, n = 1000;//sc.nextInt();
        int q = 100000;//sc.nextInt();
        String x, a[] = new String[n];
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int j = 0; j < 1000; j++)
            sb.append(rand.nextBoolean() ? 1 : 0);
        a[0] = removeZero(sb.toString());//removeZero(sc.next());
        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            rand = new Random();
            for (int j = 0; j < 1000; j++)
                sb.append(rand.nextBoolean() ? 1 : 0);
            a[i] = removeZero(sb.toString());//removeZero(sc.next());
        }
        /*for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();*/
        Date d2 = new Date();
        SegmentTree st = new SegmentTree(a, n);
        Date d1 = new Date();
        System.out.println(d1.getTime() - d2.getTime());
        for (int i = 0; i < q; i++) {
            rand = new Random();
            l = rand.nextInt(n - 1) + 1;//sc.nextInt();
            r = rand.nextInt(n - l) + l;//sc.nextInt();
            sb = new StringBuilder();
            for (int j = 0; j < 10; j++)
                sb.append(rand.nextBoolean() ? 1 : 0);
            x = removeZero(sb.toString());//removeZero(sc.next());
            //System.out.println(l + " " + r + " " + x);
            res = st.getMaxXor(n, l - 1, r - 1, x);
            /*res2 = naive(a, l - 1, r - 1, x);
            if (res != res2) {
                System.out.println((res + 1) + " " + (res2 + 1));
                st.getMaxXor(n, l - 1, r - 1, x);
            }*/
            //System.out.println(res + 1);
        }
        Date d0 = new Date();
        System.out.println(d0.getTime() - d1.getTime());
    }

    static int naive(String a[], int l, int r, String x){
        String pmax, max = "";
        int ia, ix, imax = -1;
        StringBuilder sb;
        for(int i = l; i <= r; i++){
            sb = new StringBuilder();
            ia = 0;
            ix = 0;
            if(a[i].length() > x.length()){
                for(; ia < a[i].length() - x.length(); ia++)
                    sb.append(a[i].charAt(ia));
            }
            else if(a[i].length() < x.length()){
                for(; ix < x.length() - a[i].length(); ix++)
                    sb.append(x.charAt(ix));
            }
            for(; ia < a[i].length(); ia++, ix++){
                if(a[i].charAt(ia) == x.charAt(ix))
                    sb.append(0);
                else
                    sb.append(1);
            }
            pmax = sb.toString();
            ia = 0;
            ix = 0;
            if(max.length() > pmax.length()) {
                for (; ia < max.length() - pmax.length(); ia++)
                    if(max.charAt(ia) == '1')
                        break;
                if(ia < max.length() - pmax.length())
                    continue;
            }
            else if(max.length() < pmax.length()){
                for (; ix < pmax.length() - max.length(); ix++)
                    if(pmax.charAt(ix) == '1')
                        break;
                if(ix < pmax.length() - max.length()) {
                    max = pmax;
                    imax = i;
                    continue;
                }
            }
            for (; ia < max.length(); ia++, ix++){
                if(max.charAt(ia) > pmax.charAt(ix))
                    break;
                else if(max.charAt(ia) < pmax.charAt(ix)){
                    max = pmax;
                    imax = i;
                    break;
                }
            }
        }
        return imax;
    }
}