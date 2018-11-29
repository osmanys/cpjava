import java.io.*;
import java.util.*;

public class B {

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

    static ArrayList<long[]> factorize(long n) {
        ArrayList<long[]> r = new ArrayList<>();
        int count = 0;

        while (n % 2 == 0) {
            n >>= 1;
            count++;
        }

        if (count > 0)
            r.add(new long[]{ 2, count });

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n = n / i;
            }
            if (count > 0)
                r.add(new long[]{ i, count });
        }

        if (n > 2)
            r.add(new long[]{ n, 1 });

        return r;
    }

    static long calcABC(int n, int curr, long primes[][], int a, int b, int c, long ap, long bp){
        if(ap > a || curr >= primes.length)
            return 0;
        long r = calcBC(n, 0, primes, a, b, c, ap, bp) + calcABC(n, curr + 1, primes, a, b, c, ap, bp);
        if(primes[curr][1] > 0){
            primes[curr][1]--;
            r += calcABC(n, curr, primes, a, b, c, ap * primes[curr][0], bp);
            primes[curr][1]++;
        }
        return r;
    }

    static long calcBC(int n, int curr, long primes[][], int a, int b, int c, long ap, long bp){
        if(bp > b || curr >= primes.length)
            return 0;
        long r = (n / (ap * bp) <= c ? 1 : 0) + calcBC(n, curr + 1, primes, a, b, c, ap, bp);
        if(primes[curr][1] > 0){
            primes[curr][1]--;
            r += calcBC(n, curr, primes, a, b, c, ap, bp * primes[curr][0]);
            primes[curr][1]++;
        }
        return r;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        ArrayList<long[]> p;
        long primes[][];
        int n, a, b, c, t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            p = factorize(n);
            primes = new long[p.size()][2];
            for(int i = 0; i < p.size(); i++)
                primes[i] = p.get(i);
            System.out.println(calcABC(n, 0, primes, a, b, c, 1, 1));
        }
    }
}
