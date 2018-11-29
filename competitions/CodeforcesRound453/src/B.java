import java.io.*;
import java.util.*;

public class B {
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

    static class Graph
    {
        private int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        private LinkedList<Integer> adj[];

        public int[] color;

        // Constructor
        Graph(int v)
        {
            V = v;
            color = new int[v];
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w);  // Add w to v's list.
        }

        // A function used by DFS
        int DFSUtil(int v, boolean visited[], int parent)
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            int r = (parent == color[v]) ? 0 : 1;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                    r += DFSUtil(n, visited, color[v]);
            }
            return r;
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        int DFS(int v)
        {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            return DFSUtil(v, visited, -1);
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int p, n = sc.nextInt();
        Graph g = new Graph(n);
        for(int i = 1; i < n; i++){
            p = sc.nextInt() - 1;
            g.addEdge(i, p);
            g.addEdge(p, i);
        }
        for(int i = 0; i < n; i++) {
            g.color[i] = sc.nextInt();
        }
        System.out.println(g.DFS(0));
    }
}