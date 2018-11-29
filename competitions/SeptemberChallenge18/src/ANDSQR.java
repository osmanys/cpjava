import java.io.*;
import java.util.*;

public class ANDSQR {

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

    static int BLOCK_SIZE;
    static int count[];
    static int andSum[];
    static List<Integer> startSum[];
    static List<Integer> endSum[];


    static void preprocess(int n, int a[]){
        BLOCK_SIZE = (int)Math.sqrt(Math.sqrt(n));
        if(BLOCK_SIZE == 0)
            BLOCK_SIZE = 1;
        int BLOCKS = n / BLOCK_SIZE + n % BLOCK_SIZE == 0 ? 0 : 1;
        count = new int[BLOCKS];
        startSum = new List[BLOCKS];
        endSum = new List[BLOCKS];
        int sum;
        for(int l = 0; l < BLOCKS; l++){
            startSum[l] = new ArrayList<>();
            endSum[l] = new ArrayList<>();
            for(int i = l * BLOCK_SIZE; i < (l + 1) * BLOCK_SIZE && i < n; i++){
                sum = 1 << 31 - 1;
                for(int j = i; j < (l + 1) * BLOCK_SIZE && i < n; j++) {
                    sum &= a[j];
                    if(i == l * BLOCK_SIZE)
                        startSum[l].add(sum);
                    if((int)Math.sqrt(sum) * (int)Math.sqrt(sum) == sum)
                        count[l]++;
                }
                endSum[l].add(sum);
                if(i == l * BLOCK_SIZE)
                    andSum[l] = sum;
            }
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int l, r, n, q, t = sc.nextInt();
        int a[];
        while(t-- > 0) {
            n = sc.nextInt();
            q = sc.nextInt();
            a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            preprocess(n, a);
            for(int i = 0; i < q; i++){
                l = sc.nextInt();
                r = sc.nextInt();

            }
        }
    }
}
