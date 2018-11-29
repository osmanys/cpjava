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

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int c, r, n, t = sc.nextInt();
        int d[], count[];
        double min;
        List<Integer> s;
        while(t-- > 0){
            n = sc.nextInt();
            d = new int[n];
            for(int i = 0; i < n; i++)
                d[i] = sc.nextInt();
            s = new ArrayList<>();
            if(n < 10000) {
                Arrays.sort(d);
                for (int i = 0; i + 1 < n; i++) {
                    c = 1;
                    while (i + 1 < n && d[i] == d[i + 1]) {
                        i++;
                        c++;
                    }
                    if (c >= 2)
                        s.add(d[i]);
                    if (c >= 4)
                        s.add(d[i]);
                }
            }
            else{
                count = new int[10001];
                for(int i = 0; i < n; i++)
                    count[d[i]]++;
                for(int i = 0; i < 10001; i++){
                    if (count[i] >= 2)
                        s.add(i);
                    if (count[i] >= 4)
                        s.add(i);
                }
            }
            min = Double.MAX_VALUE;
            r = 0;
            for(int i = 0; i + 1 < s.size(); i++){
                if(min > (s.get(i) * s.get(i) + s.get(i + 1) * s.get(i + 1)) / (1d * s.get(i) * s.get(i + 1))){
                    min = (s.get(i) * s.get(i) + s.get(i + 1) * s.get(i + 1)) / (1d * s.get(i) * s.get(i + 1));
                    r = i;
                }
            }
            System.out.println(s.get(r) + " " + s.get(r) + " " + s.get(r + 1) + " " + s.get(r + 1));
        }
    }
}
