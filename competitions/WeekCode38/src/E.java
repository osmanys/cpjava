import java.io.*;
import java.util.*;

public class E {

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

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int u, v, t = sc.nextInt();
        V = n;
        graph = new int[n][n];
        for(int i = 0; i < m; i++){
            u = sc.nextInt();
            v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        for(int i = 0; i < k; i++)
            dijkstra(0);
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                p.add(graph[i][j]);
        int cur = p.poll();
        int count = 1;
        while(t > 0){
            int poll = p.poll();
            if(t > count * (cur - poll))
                t -= count * (cur - poll);
            else{
                cur -= t / count;
                break;
            }
            cur = poll;
            count++;
        }
        System.out.println(Math.max(0, cur - 2));
    }

    static int graph[][];
    static int V;

    static int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    static void dijkstra(int src)
    {
        int dist[] = new int[V];
        int parents[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parents[v] = u;
                }
        }
        update(parents);
    }

    static void update(int parents[]){
        int cur = V - 1;
        while(cur != 0){
            graph[cur][parents[cur]]++;
            graph[parents[cur]][cur]++;
            cur = parents[cur];
        }
    }
}
