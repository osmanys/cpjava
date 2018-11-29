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

        void DFSUtil(int v, boolean visited[], PriorityQueue<Integer> f, int d[]) {
            visited[v] = true;
            f.add(d[v]);

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited, f, d);
            }
        }

        ArrayList<PriorityQueue<Integer>> DFS(int d[]) {
            boolean visited[] = new boolean[V];
            ArrayList<PriorityQueue<Integer>> forrest = new ArrayList<>();
            PriorityQueue<Integer> p;
            for (int i = 0; i < V; ++i) {
                if (visited[i] == false) {
                    p = new PriorityQueue<>();
                    DFSUtil(i, visited, p, d);
                    forrest.add(p);
                }
            }
            return  forrest;
        }
    }

    static class Node{
        int index;
        int val;

        Node(int index, int val){
            this.index = index;
            this.val = val;
        }
    }

    static class NodeComparator implements Comparator<Node>
    {
        @Override
        public int compare(Node x, Node y)
        {
            if(x.val < y.val)
                return -1;
            else if(x.val > y.val)
                return 1;
            return 0;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int x, y, n = sc.nextInt();
        int m = sc.nextInt();
        Graph g = new Graph(n);
        int d[] = new int[n];
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();
        for(int i = 0; i < m; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            g.addEdge(x, y);
            g.addEdge(y, x);
        }
        ArrayList<PriorityQueue<Integer>> f = g.DFS(d);
        if(f.size() == 1){
            System.out.println(0);
            return;
        }
        PriorityQueue<Node> p = new PriorityQueue<>(new NodeComparator());
        PriorityQueue<Node> pt = new PriorityQueue<>(new NodeComparator());
        for(int i = 0; i < f.size(); i++) {
            x = f.get(i).remove();
            p.add(new Node(i, x));
            pt.add(new Node(i, x));
        }
        boolean visited[] = new boolean[n];
        pt.remove();
        pt.remove();
        Node c, ct;
        c = p.remove();
        ct = p.remove();
        long r = c.val + ct.val;
        visited[c.index] = true;
        visited[ct.index] = true;
        if(!f.get(c.index).isEmpty())
            pt.add(new Node(c.index, f.get(c.index).remove()));
        if(!f.get(ct.index).isEmpty())
            pt.add(new Node(ct.index, f.get(ct.index).remove()));
        while(!p.isEmpty()){
            c = p.peek();
            if(visited[c.index] == true){
                p.remove();
                continue;
            }
            if(pt.isEmpty())
                break;
            ct = pt.peek();
            if(c.index == ct.index) {
                pt.remove();
                continue;
            }
            r += c.val + ct.val;
            visited[c.index] = true;
            visited[ct.index] = true;
            pt.remove();
            p.remove();
            if(!f.get(c.index).isEmpty())
                pt.add(new Node(c.index, f.get(c.index).remove()));
        }
        if(!p.isEmpty())
            System.out.println("Impossible");
        else
            System.out.println(r);
    }
}
