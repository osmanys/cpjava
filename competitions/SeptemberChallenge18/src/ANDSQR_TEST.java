import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ANDSQR_TEST {

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

    static void convertToBinary(int n){
        int container[] = new int[30];
        int i = 0;
        while (n > 0){
            container[i] = n % 2;
            i++;
            n = n / 2;
        }
        for (int j = i -1 ; j >= 0 ; j--)
            System.out.print(container[j]);
    }

    public static void main (String[] args) {
        int n = 1 << 15;
        for(int i = 0; i * i < n; i++){
            System.out.print(i + " " + (i * i) + ": ");
            convertToBinary(i * i);
            System.out.println();
        }
    }
}
