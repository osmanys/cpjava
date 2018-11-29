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
        int n = sc.nextInt();
        Integer a[] = new Integer[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a, Collections.reverseOrder());
        Integer b[] = new Integer[n];
        for(int i = 0; i < n; i++)
            b[i] = sc.nextInt();
        Arrays.sort(b, Collections.reverseOrder());
        long diff = 0;
        int cra = 0, crb = 0;
        boolean turna = true;
        while(cra < n || crb < n){
            if(turna){
                if(cra < n && crb < n){
                    if(a[cra] >= b[crb]){
                        diff += a[cra];
                        cra++;
                    }
                    else
                        crb++;
                }
                else if(cra < n){
                    diff += a[cra];
                    cra++;
                }
                else{
                    crb++;
                }
                turna = false;
            }
            else{
                if(cra < n && crb < n){
                    if(b[crb] >= a[cra]){
                        diff -= b[crb];
                        crb++;
                    }
                    else
                        cra++;
                }
                else if(crb < n){
                    diff -= b[crb];
                    crb++;
                }
                else{
                    cra++;
                }
                turna = true;
            }
        }
        System.out.println(diff);
    }
}
