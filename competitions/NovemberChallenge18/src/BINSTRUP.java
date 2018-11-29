import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class BINSTRUP {

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
        String value;

        Max(int index, String value) {
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

        Max searchMaxXor(String key, String partialMax) {
            int shiftPartial, shiftKey, next, index, level, keylength = key.length();

            if (partialMax != null) {
                for (level = 0; level < partialMax.length(); level++)
                    if (partialMax.charAt(level) == '1')
                        break;
                if (partialMax.length() - level > keylength && partialMax.length() - level > length)
                    return new Max(-1, null);
            }

            StringBuilder max = new StringBuilder();
            TrieNode pCrawl = root;

            boolean eq = true;
            level = 0;
            if (keylength > length) {
                shiftPartial = partialMax != null ? partialMax.length() - keylength : 0;
                for (; level < keylength - length; level++) {
                    if (partialMax != null) {
                        if (eq && key.charAt(level) < (shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)))
                            return new Max(-1, null);
                        else if (key.charAt(level) > (shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)))
                            eq = false;
                    }
                    max.append(key.charAt(level));
                }
                level = 0;
            } else if (keylength < length) {
                shiftPartial = partialMax != null ? partialMax.length() - length : 0;
                for (; level < length - keylength; level++) {
                    if (pCrawl.children[1] != null) {
                        if (partialMax != null) {
                            if ((shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)) == '0')
                                eq = false;
                        }
                        next = 1;
                    } else {
                        if (partialMax != null) {
                            if (eq && (shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)) == '1')
                                return new Max(-1, null);
                        }
                        next = 0;
                    }
                    max.append(next);
                    pCrawl = pCrawl.children[next];
                }
            }

            for (; level < length; level++) {
                shiftPartial = partialMax != null ? partialMax.length() - length : 0;
                shiftKey = keylength - length;
                index = key.charAt(shiftKey + level) - '0';
                if ((index == 0 && pCrawl.children[1] != null) || (index == 1 && pCrawl.children[0] != null)) {
                    if (partialMax != null && (shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)) == '0')
                        eq = false;
                    next = index == 0 ? 1 : 0;
                    max.append(1);
                } else {
                    if (eq && partialMax != null && (shiftPartial + level < 0 ? '0' : partialMax.charAt(shiftPartial + level)) == '1')
                        return new Max(-1, null);
                    next = index == 0 ? 0 : 1;
                    max.append(0);
                }
                pCrawl = pCrawl.children[next];
            }

            return new Max(pCrawl.index, max.toString());
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

        int getMaxXor(int n, int qs, int qe, String key) {
            if (qs < 0 || qe > n - 1 || qs > qe)
                return -1;
            Max m = getMaxXorUtil(0, n - 1, qs, qe, 0, key, null);
            return m.index;
        }

        Max getMaxXorUtil(int ss, int se, int qs, int qe, int si, String key, String partialMax) {
            if (qs <= ss && qe >= se)
                return st[si].searchMaxXor(key, partialMax);

            if (se < qs || ss > qe)
                return new Max(-1, null);

            int mid = getMid(ss, se);
            Max m1 = getMaxXorUtil(ss, mid, qs, qe, 2 * si + 1, key, partialMax);
            Max m2 = getMaxXorUtil(mid + 1, se, qs, qe, 2 * si + 2, key, m1.index != -1 ? m1.value : partialMax);

            return m2.index != -1 ? m2 : m1;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int res, l, r, n = sc.nextInt();
        int q = sc.nextInt();
        String x, a[] = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.next();
        SegmentTree st = new SegmentTree(a, n);
        for (int i = 0; i < q; i++) {
            l = sc.nextInt();
            r = sc.nextInt();
            x = sc.next();
            res = st.getMaxXor(n, l - 1, r - 1, x);
            System.out.println(res + 1);
        }
    }
}