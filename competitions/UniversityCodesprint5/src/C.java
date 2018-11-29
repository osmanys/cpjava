import java.io.*;
import java.util.*;

public class C {

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

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void DFSUtil(int v, boolean visited[], List<Integer> l) {
            visited[v] = true;
            l.add(adj[v].size());
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited, l);
            }
        }

        int calc(int a, int b) {
            boolean visited[] = new boolean[V];
            int min, max, r = 0;
            for (int i = 0; i < V; ++i)
                if (visited[i] == false) {
                    List<Integer> l = new ArrayList<>();
                    DFSUtil(i, visited, l);
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    for(int j = 0; j < l.size(); j++){
                        if(min > l.get(j))
                            min = l.get(j);
                        if(max < l.get(j))
                            max = l.get(j);
                    }
                    for(int j = 0; j < l.size(); j++)
                        if(l.get(j) > (long)a * min && l.get(j) < (long)b * max)
                            r++;
                }
            return r;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int x, y, b = sc.nextInt();
        Graph g = new Graph(n);
        for(int i = 0; i < m; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            g.addEdge(x - 1, y - 1);
            g.addEdge(y - 1, x - 1);
        }
        System.out.println(g.calc(a, b));
    }
}
