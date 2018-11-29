package Round1;

import java.io.*;
import java.util.*;

public class SolutionB {

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String inputFile) throws IOException
        {
            FileInputStream fis = new FileInputStream(inputFile);
            DataInputStream in = new DataInputStream(fis);

            br = new BufferedReader(new
                    InputStreamReader(in));
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

    private static void preorder(int graph[][], int pos, List<Integer> result) {
        result.add(pos);
        if (graph[pos][0] != -1)
            preorder(graph, graph[pos][0], result);
        if (graph[pos][1] != -1)
            preorder(graph, graph[pos][1], result);
    }

    private static void postorder(int graph[][], int pos, List<Integer> result) {
        if (graph[pos][0] != -1)
            postorder(graph, graph[pos][0], result);
        if (graph[pos][1] != -1)
            postorder(graph, graph[pos][1], result);
        result.add(pos);
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

    public static void main (String[] args) throws IOException {
        File f = new File("output.txt");
        FileWriter fw = new FileWriter(f);
        FastReader sc = new FastReader("input.txt");
        int r[], graph[][], n, k, t = 0, T = sc.nextInt();
        HashMap<Integer, Integer> setNum;
        List<Integer> pre, post;
        DisjointUnionSets djs;
        StringBuilder res;
        while(t++ < T){
            n = sc.nextInt();
            k = sc.nextInt();
            graph = new int[n][2];
            r = new int[n];
            for(int i = 0; i < n; i++){
                graph[i][0] = sc.nextInt() - 1;
                graph[i][1] = sc.nextInt() - 1;
            }
            pre = new ArrayList<>();
            preorder(graph, 0, pre);
            post = new ArrayList<>();
            postorder(graph, 0, post);
            djs = new DisjointUnionSets(n);
            for(int i = 0; i < n; i++)
                djs.union(pre.get(i), post.get(i));
            setNum = new HashMap<>();
            for(int i = 0; i < n; i++) {
                r[i] = djs.find(i);
                if(!setNum.containsKey(r[i]))
                    setNum.put(r[i], k == 0 ? 1 : k--);
            }
            if(k > 0)
                res = new StringBuilder("Impossible");
            else {
                res = new StringBuilder();
                for (int i = 0; i < n; i++)
                    res.append(setNum.get(r[i])).append(" ");
            }
            fw.write("Case #" + t + ": " + res.toString().trim() + "\n");
            fw.flush();
        }
    }
}
