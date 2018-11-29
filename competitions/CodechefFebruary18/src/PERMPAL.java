import java.io.*;
import java.util.*;

public class PERMPAL {

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
        int m, i, c, t = sc.nextInt();
        String l;
        ArrayList<Integer> s[] = new ArrayList[26];
        int p[];
        while(t-- > 0){
            m = -1;
            for(i = 0; i < 26; i++)
                s[i] = new ArrayList<>();
            l = sc.nextLine();
            for(i = 0; i < l.length(); i++)
                s[l.charAt(i) - 'a'].add(i);
            p = new int[l.length()];
            c = 0;
            for(i = 0; i < 26; i++){
                if(s[i].size() % 2 == 1){
                    if(m == -1)
                        m = s[i].get(s[i].size() - 1);
                    else
                        break;
                }
                for(int j = 0; j + 1 < s[i].size(); j += 2){
                    p[c] = s[i].get(j);
                    p[l.length() - c - 1] = s[i].get(j + 1);
                    c++;
                }
            }
            if(i < 26)
                System.out.println(-1);
            else{
                if(m != -1)
                    p[c] = m;
                for(i = 0; i < l.length(); i++)
                    System.out.print((p[i] + 1) + " ");
                System.out.println();
            }
        }
    }
}
