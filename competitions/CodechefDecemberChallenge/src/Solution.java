// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
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

    static int CeilIndex(long A[], int l, int r, long key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m] > key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(long A[], int size)
    {
        // Add boundary case, when array size is one

        long[] tailTable   = new long[size];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] - 1 < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] + 1 > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
        return len;
    }

    static long d[] = new long[100000];

    public static void main (String[] args) throws java.lang.Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            d[i] = sc.nextLong();
        System.out.println(n - LongestIncreasingSubsequenceLength(d, n));
    }
}