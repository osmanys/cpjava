import java.io.*;
import java.util.*;

public class F {

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

    static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Graph {
        private Point[] points;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            adj = new LinkedList[v];
            points = new Point[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addVertex(int idx, Point p) {
            Point r = new Point(-1, -1);
            int i, v = 0;
            while(adj[v].size() > 0){
                i = adj[v].size() - 1;
                if(r.x == -1){
                    r.x = points[adj[v].get(i)].x;
                    r.y = points[adj[v].get(i)].y;
                    v = adj[v].get(i);
                }
                else if(areaTriangle(r, p, points[adj[v].get(i)]) > 0){
                    r.x = points[adj[v].get(i)].x;
                    r.y = points[adj[v].get(i)].y;
                    v = adj[v].get(i);
                }
                else
                    break;
            }
            adj[v].add(idx);
            points[idx] = p;
        }

        Point find(Point p, int l){
            Point r = new Point(-1, -1);
            int i, v = 0;
            while(adj[v].size() > 0){
                for(i = adj[v].size() - 1; i >= 0 && adj[v].get(i) > l; i--);
                if(i == -1)
                    break;
                if(r.x == -1){
                    r.x = points[adj[v].get(i)].x;
                    r.y = points[adj[v].get(i)].y;
                    v = adj[v].get(i);
                }
                else if(areaTriangle(r, p, points[adj[v].get(i)]) > 0){
                    r.x = points[adj[v].get(i)].x;
                    r.y = points[adj[v].get(i)].y;
                    v = adj[v].get(i);
                }
                else
                    break;
            }
            if(r.x == -1)
                return p;
            else
                return r;
        }
    }

    static long areaTriangle(Point a, Point b, Point c) {
        return (1L * a.x * (b.y - c.y) + 1L * b.x * (c.y - a.y) + 1L * c.x * (a.y - b.y));
    }

    static final int MOD = 1000000007;

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x[] = new int[n];
        for(int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        int y[] = new int[n];
        for(int i = 0; i < n; i++)
            y[i] = sc.nextInt();
        int z[] = new int[n];
        for(int i = 0; i < n; i++)
            z[i] = sc.nextInt();
        long f;
        int g = 0, h, c, l;
        Graph tree = new Graph(n + 1);
        Point p;
        for(int i = 1; i <= n; i++){
            h = x[i - 1] ^ g;
            c = y[i - 1] ^ g;
            l = z[i - 1] ^ g;
            tree.addVertex(i, new Point(h, c));
            p = tree.find(new Point(h, c), i - l);
            f = 1L * p.x * c - 1L * p.y * h;
            g = (int)((((f + g) % MOD) + MOD) % MOD);
        }
        System.out.println(g);
    }
}
