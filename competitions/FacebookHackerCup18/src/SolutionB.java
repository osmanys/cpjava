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

    static class Graph {
        private LinkedList<Integer> adj[];
        private int max[];
        private int V;

        Graph(int v) {
            V = v;
            max = new int[v];
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        long process(int cn[], int p[]) {
            Stack<Integer> s = new Stack();
            Queue<Integer> q = new LinkedList();
            q.add(0);

            int n, c, v;
            Iterator<Integer> it;
            while (!q.isEmpty()) {
                n = q.peek();
                q.remove();
                s.push(n);
                max[n] = n;

                it = adj[n].listIterator();
                while (it.hasNext())
                    q.add(it.next());
            }

            long res = 0;
            boolean selected[] = new boolean[V];
            while (!s.empty()) {
                v = s.peek();
                // process
                for(int k = 0; k < cn[v]; k++) {
                    if(max[v] == -1)
                        break;

                    res += max[v];
                    c = max[v];
                    selected[c] = true;

                    it = adj[c].listIterator();
                    max[c] = -1;
                    while (it.hasNext()) {
                        n = it.next();
                        if(max[c] < max[n])
                            max[c] = max[n];
                    }

                    while(c != v) {
                        it = adj[p[c]].listIterator();
                        max[p[c]] = selected[p[c]] ? -1 : p[c];
                        while (it.hasNext()) {
                            n = it.next();
                            if(max[p[c]] < max[n])
                                max[p[c]] = max[n];
                        }
                        c = p[c];
                    }
                }
                if(v != 0 && max[p[v]] < max[v])
                    max[p[v]] = max[v];

                s.pop();
            }
            return res;
        }
    }

    public static void main (String[] args) throws IOException {
        File f = new File("output.txt");
        FileWriter fw = new FileWriter(f);
        FastReader sc = new FastReader("input.txt");
        int n, m, b, t = 0, T = sc.nextInt();
        long a;
        int p[], c[], cn[];
        Graph tree;
        while(t++ < T){
            n = sc.nextInt();
            m = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            p = new int[n];
            tree = new Graph(n);
            for(int i = 1; i < n; i++) {
                p[i] = sc.nextInt();
                tree.addEdge(p[i], i);
            }
            c = new int[m];
            cn = new int[n];
            for(int i = 0; i < m; i++) {
                c[i] = (int) ((a * i + b) % n);
                cn[c[i]]++;
            }
            fw.write("Case #" + t + ": " + tree.process(cn, p) + "\n");
            fw.flush();
        }
    }
}
