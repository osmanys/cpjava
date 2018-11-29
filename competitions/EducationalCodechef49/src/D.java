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

    static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        private void makeSet() {
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else{
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int d, n = sc.nextInt();
        int c[] = new int[n];
        for(int i = 0; i < n; i++)
            c[i] = sc.nextInt();
        DisjointUnionSets djs = new DisjointUnionSets(n);
        for(int i = 0; i < n; i++) {
            d = sc.nextInt();
            djs.union(i, d - 1);
        }
        HashMap<Integer, Integer> setMin = new HashMap<>();
        for(int i = 0; i < n; i++) {
            d = djs.find(i);
            if(setMin.containsKey(d)){
                if(setMin.get(d) > c[i])
                    setMin.replace(d, c[i]);
            }
            else
                setMin.put(d, c[i]);
        }
        int r = 0;
        Iterator it = setMin.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry)it.next();
            r += pair.getValue();
        }
        System.out.println(r);
    }
}
