import java.util.LinkedList;
import java.util.Scanner;

class CHEFFIB {
    private static final int MAX = 300000;
    private static final long MOD = 1000000007;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        buildFib();
        int v, k, typ, x, y, n, q, t = sc.nextInt();
        long a, b;
        Graph g;
        while(t-- > 0){
            n = sc.nextInt();
            q = sc.nextInt();
            g = new Graph(n);
            for(int i = 0; i < n - 1; i++){
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                g.addEdge(x, y);
                g.addEdge(y, x);
            }
            for(int i = 0; i < q; i++){
                typ = sc.nextInt();
                if(typ == 1){
                    v = sc.nextInt() - 1;
                    k = sc.nextInt();
                    a = sc.nextLong();
                    b = sc.nextLong();
                    g.updateFib(v, k, a, b);
                }
                else{
                    v = sc.nextInt() - 1;
                    System.out.println(g.getValue(v));
                }
            }
        }
    }

    private static long f[];

    private static void buildFib(){
        f = new long[MAX];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i < MAX; i++)
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
    }

    private static long fib(int n, long a, long b){
        if(n == 0)
            return a;
        return (a * f[n - 1] + b * f[n]) % MOD;
    }

    private static class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        private long val[];

        Graph(int v) {
            V = v;
            val = new long[v];
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        private void utilUpdateFib(int v, boolean visited[], int k, int d, long a, long b) {
            if(k < d)
                return;
            visited[v] = true;
            val[v] = (val[v] + fib(d, a, b)) % MOD;
            for (int n : adj[v]) {
                if (!visited[n])
                    utilUpdateFib(n, visited, k, d + 1, a, b);
            }
        }

        void updateFib(int v, int k, long a, long b) {
            boolean[] visited = new boolean[V];
            utilUpdateFib(v, visited, k, 0, a, b);
        }

        long getValue(int v){
            return val[v];
        }
    }
}
