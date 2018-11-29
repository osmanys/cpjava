package Round1A;

import java.io.*;
import java.util.*;

public class ARRGRAPH {

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

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static boolean _gcd[][];

    static void precalc(){
        _gcd = new boolean[51][51];
        for(int i = 2; i <= 50; i++)
            for(int j = 2; j <= 50; j++)
                _gcd[i][j] = gcd(i, j) == 1;
    }

    public static void main (String[] args) {
        precalc();
        FastReader sc = new FastReader();
        int last_changed, d[], n, t = sc.nextInt();
        int p[] = new int[]{29, 31, 37, 41, 43, 47};
        boolean found, r[];
        StringBuffer sb;
        LinkedList<Integer> l;
        while(t-- > 0){
            n = sc.nextInt();
            d = new int[n];
            sb = new StringBuffer();
            for(int i = 0; i < n - 1; i++) {
                d[i] = sc.nextInt();
                sb.append(d[i]).append(' ');
            }
            d[n - 1] = sc.nextInt();
            l = new LinkedList<>();
            l.add(d[0]);
            for(int i = 1; i < n; i++) {
                found = false;
                for (int j = 0; j < l.size(); j++){
                    if(_gcd[l.get(j)][d[i]]){
                        if(found){
                            l.remove(j);
                            j--;
                        }
                        found = true;
                    }
                }
                if(!found)
                    l.add(d[i]);
            }
            last_changed = -1;
            if(l.size() > 1) {
                r = new boolean[5];
                for(int i = 0; i < n; i++){
                    for (int j = 0; j < 5; j++) {
                        if (d[i] % p[j] == 0)
                            r[j] = true;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if (!r[i]) {
                        last_changed = p[i];
                        break;
                    }
                }
            }
            System.out.println(last_changed == -1 ? 0 : 1);
            System.out.print(sb.toString());
            System.out.println(last_changed == -1 ? d[d.length - 1] : last_changed);
        }
    }
}
