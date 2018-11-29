import java.io.*;
import java.util.*;

public class A {

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
        int ac, ct, r, c, h, v, T = sc.nextInt();
        String l;
        int cc[], cr[];
        char d[][];
        Vector<Integer> rl, cl;
        for(int t = 1; t <= T; t++) {
            System.out.print("Case #" + t + ": ");
            r = sc.nextInt();
            c = sc.nextInt();
            h = sc.nextInt();
            v = sc.nextInt();
            d = new char[r][c];
            cr = new int[r];
            cc = new int[c];
            ct = 0;
            rl = new Vector<>();
            cl = new Vector<>();
            for(int i = 0; i < r; i++){
                l = sc.nextLine();
                for(int j = 0; j < c; j++) {
                    d[i][j] = l.charAt(j);
                    if(d[i][j] == '@') {
                        cr[i]++;
                        cc[j]++;
                        ct++;
                    }
                }
            }
            if(ct > 0 && ct % ((h + 1) * (v + 1)) != 0)
                System.out.println("IMPOSSIBLE");
            else{
                ac = 0;
                int i = 0;
                for(; i < r; i++){
                    ac += cr[i];
                    if(ac > ct / (h + 1)){
                        System.out.println("IMPOSSIBLE");
                        break;
                    }
                    else if(ac == ct / (h + 1)) {
                        ac = 0;
                        rl.add(i);
                    }
                }
                if(i == r){
                    ac = 0;
                    i = 0;
                    for(; i < c; i++){
                        ac += cc[i];
                        if(ac > ct / (v + 1)){
                            System.out.println("IMPOSSIBLE");
                            break;
                        }
                        else if(ac == ct / (v + 1)) {
                            ac = 0;
                            cl.add(i);
                        }
                    }
                    if(i == c) {
                        for(i = 0; i < rl.size(); i++){
                            int j = 0;
                            for(; j < cl.size(); j++){
                                ac = 0;
                                for(int k = (i == 0 ? 0 : rl.get(i - 1) + 1); k <= rl.get(i); k++){
                                    for(int m = (j == 0 ? 0 : cl.get(j - 1) + 1); m <= cl.get(j); m++){
                                        if(d[k][m] == '@')
                                            ac++;
                                    }
                                }
                                if(ac != ct / ((h + 1) * (v + 1))){
                                    System.out.println("IMPOSSIBLE");
                                    break;
                                }
                            }
                            if(j < cl.size())
                                break;
                        }
                        if(i == rl.size())
                            System.out.println("POSSIBLE");
                    }
                }
            }
        }
    }
}
