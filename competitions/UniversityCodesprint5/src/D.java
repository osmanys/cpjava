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

    static class Node {
        Node left = null;
        Node right = null;
        Node parent = null;
        int leaf = 1;

        void update() {
            if (right != null && left != null)
                leaf = right.leaf + left.leaf;
            else if (left != null)
                leaf = left.leaf;
            else if (right != null)
                leaf = right.leaf;

            if (parent != null)
                parent.update();
        }

        void insert(String num, int level) {
            if (level == -1) {
                update();
                return;
            }
            int x = num.charAt(level) - '0';
            if (x == 1) {
                if (right == null) {
                    Node tmp = new Node();
                    right = tmp;
                    tmp.parent = this;
                }
                right.insert(num, level - 1);
            } else {
                if (left == null) {
                    Node tmp = new Node();
                    left = tmp;
                    tmp.parent = this;
                }
                left.insert(num, level - 1);
            }
        }

        long solveUtil(String num, String k, int level) {
            if (level == -1)
                return 0;
            long r = 0;
            if (num.charAt(level) == '1') {
                if (k.charAt(level) == '1') {
                    if (right != null)
                        r += right.leaf;
                    if (left != null)
                        r += solveUtil(num, k, level - 1);
                } else {
                    if (right != null)
                        r += solveUtil(num, k, level - 1);
                }

            } else {
                if (k.charAt(level) == '0') {
                    if (left != null)
                        r += solveUtil(num, k, level - 1);
                } else {
                    if (left != null)
                        r += left.leaf;
                    if (right != null)
                        r += solveUtil(num, k, level - 1);
                }
            }
            return r;
        }
    }

    static long solve(int a[], int n, int K) {
        int maxEle = K;

        for (int i = 0; i < n; i++)
            maxEle = Math.max(maxEle, a[i]);

        int height = (int) Math.log(maxEle) + 100;
        String k = "";
        int temp = K;

        for (int j = 0; j < height; j++) {
            k = k + temp % 2;
            temp = temp >> 1;
        }

        String init = "";
        for (int i = 0; i < height; i++)
            init += '0';

        Node head = new Node();
        head.insert(init, height - 1);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            String s = "";
            temp = a[i];

            for (int j = 0; j < height; j++) {
                s = s + temp % 2;
                temp = temp >> 1;
            }

            ans += head.solveUtil(s, k, height - 1);
            head.insert(s, height - 1);
        }

        return ans;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = 4;//sc.nextInt();
        int k = 1000000000;//sc.nextInt();
        int d[] = new int[n];
        for(int i = 0; i < n; i++)
            d[i] = 1;//sc.nextInt();
        System.out.print(solve(d, n, k));
    }
}
