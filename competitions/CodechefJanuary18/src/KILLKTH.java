import java.io.*;
import java.util.*;

public class KILLKTH {

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

    static class SuffixTree {
        static final int END = 1 << 30;

        private String input;
        private int len;

        private int currentPos;
        private Node root;

        private Node activeNode;
        private int activeEdge;
        private int activeLength;

        private int remainder;

        private boolean firstNodeCreated;
        private Node lastNodeCreated;

        SuffixTree(String input) {
            this.input = input;
            this.len = input.length();
            this.root = new Node(0, 0);
            this.activeEdge = 0;
            this.activeLength = 0;
            this.remainder = 0;
            this.activeNode = root;
            this.currentPos = 0;
            this.lastNodeCreated = null;
            this.firstNodeCreated = false;

            for (currentPos = 0; currentPos < len; currentPos++)
                addSuffix();

            countOcurrences(root);
        }

        private int countOcurrences(Node n){
            if(n.end == END) {
                n.occurrences = 1;
                return 1;
            }
            int r = 0;
            int i = 36;
            if (n.child[i] != null)
                r += countOcurrences(n.child[i]);
            for (i = 97; i < 123; i++) {
                if (n.child[i] != null)
                    r += countOcurrences(n.child[i]);
            }
            n.occurrences = r;
            return r;
        }

        List<SuffixIndex> buildIndexList(){
            List<SuffixIndex> si = new ArrayList<>();
            long index = 0;
            int i = 36;
            if (root.child[i] != null)
                index = buildIndexList(root.child[i], 0, index, si);
            for (i = 97; i < 123; i++)
                if (root.child[i] != null)
                    index = buildIndexList(root.child[i], 0, index, si);
            return si;
        }

        private long buildIndexList(Node n, int length, long index, List<SuffixIndex> si){
            int end = n.end == END ? input.length() - 1 : n.end;
            if(n.start != end) {
                si.add(new SuffixIndex(index, length + end - n.start, n.start, end, n.occurrences));
                index += n.occurrences * (1L * (length + end - n.start) * (length + end - n.start + 1) - length * (length + 1)) / 2;
                int i = 36;
                if (n.child[i] != null)
                    index = buildIndexList(n.child[i], length + end - n.start, index, si);
                for (i = 97; i < 123; i++) {
                    if (n.child[i] != null)
                        index = buildIndexList(n.child[i], length + end - n.start, index, si);
                }
            }
            return index;
        }

        private void addSuffix() {
            remainder++;
            firstNodeCreated = true;
            while (remainder > 0) {
                if (activeLength == 0)
                    activeEdge = currentPos;

                if (activeNode.child[input.charAt(activeEdge)] == null) {
                    activeNode.child[input.charAt(activeEdge)] = new Node(currentPos, END);
                    addSuffixLink(activeNode);
                } else {
                    int nextLen = activeNode.child[input.charAt(activeEdge)].getLength();
                    if (activeLength >= nextLen) {
                        activeNode = activeNode.child[input.charAt(activeEdge)];
                        activeEdge += nextLen;
                        activeLength -= nextLen;
                        continue;
                    }
                    if (input.charAt(activeNode.child[input.charAt(activeEdge)].start + activeLength) == input.charAt(currentPos)) {
                        activeLength++;
                        addSuffixLink(activeNode);
                        break;
                    } else {
                        Node old = activeNode.child[input.charAt(activeEdge)];

                        Node split = new Node(old.start, old.start + activeLength);
                        activeNode.child[input.charAt(activeEdge)] = split;

                        Node leaf = new Node(currentPos, END);

                        split.child[input.charAt(currentPos)] = leaf;

                        old.start += activeLength;

                        split.child[input.charAt(old.start)] = old;
                        addSuffixLink(split);
                    }
                }
                remainder--;
                if (activeNode == root && activeLength > 0) {
                    activeLength--;
                    activeEdge = currentPos - remainder + 1;
                }
                else {
                    if (activeNode.suffix != null) {
                        activeNode = activeNode.suffix;
                    } else {
                        activeNode = root;
                    }
                }
            }
        }

        private void addSuffixLink(Node curr) {
            if (!firstNodeCreated)
                lastNodeCreated.suffix = curr;
            firstNodeCreated = false;
            lastNodeCreated = curr;
        }

        private class Node {
            int start, end;
            Node[] child;
            Node suffix;
            int occurrences;

            Node(int start, int end) {
                child = new Node[256];
                suffix = null;
                this.start = start;
                this.end = end;
            }

            private int getLength() {
                return Math.min(currentPos + 1, end) - start;
            }
        }
    }

    static class SuffixIndex{
        long index;
        int length;
        int start;
        int end;
        int occurrences;

        SuffixIndex(long index, int length, int start, int end, int occurrences){
            this.index = index;
            this.length = length;
            this.start = start;
            this.end = end;
            this.occurrences = occurrences;
        }
    }

    private static int findKth(List<SuffixIndex> si , long k){
        int t = lower_bound(si, k, 0, si.size() - 1);
        SuffixIndex cur = si.get(t);

        k -= cur.index;
        long a = cur.occurrences;
        long b = (2 * cur.start - 2 * (cur.end - cur.length) + 1) * cur.occurrences;
        long c = - 2 * k;

        long n = (- b + (long)Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        k -= (a * n * n + b * n) / 2;
        k %= (cur.start - (cur.end - cur.length) + n + 1);

        return (cur.end - cur.length) + (int)k;
    }

    private static int lower_bound(List<SuffixIndex> si, long k, int start, int end){
        int mid = (start + end) / 2;
        if(k >= si.get(mid).index) {
            if (mid == si.size() - 1 || k < si.get(mid + 1).index)
                return mid;
            else
                return lower_bound(si, k, mid + 1, end);
        }
        else{
            if (mid == 1 || k >= si.get(mid - 1).index)
                return mid - 1;
            else
                return lower_bound(si, k, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        String txt = sc.nextLine() + "$";
        SuffixTree st = new SuffixTree(txt);
        List<SuffixIndex> si = st.buildIndexList();
        int idx, q = sc.nextInt();
        long g = 0, p, m, k;
        while(q-- > 0){
            p = sc.nextLong();
            m = sc.nextLong();
            k = (p * g) % m + 1;
            idx = findKth(si, k - 1);
            System.out.println(txt.charAt(idx));
            g += txt.charAt(idx);
        }
    }
}
