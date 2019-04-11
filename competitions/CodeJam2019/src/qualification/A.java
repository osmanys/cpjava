package qualification;

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
        int c = sc.nextInt();
        String n;
        StringBuilder sba, sbb;
        for(int t = 1; t <= c; t++) {
            sba = new StringBuilder();
            sbb = new StringBuilder();
            n = sc.next();
            for(int i = 0; i < n.length(); i++){
                if(n.charAt(i) == '4'){
                    sba.append(2);
                    sbb.append(2);
                }
                else{
                    sba.append(n.charAt(i));
                    if(sbb.length() > 0)
                        sbb.append(0);
                }
            }
            System.out.println("Case #" + t + ": " + sba.toString() + " " + sbb.toString());
        }
    }
}
