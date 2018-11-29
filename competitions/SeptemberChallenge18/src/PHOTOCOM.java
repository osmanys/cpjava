import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PHOTOCOM {

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

    static int count(int c[][], int hs, int ws, int hf, int wf, boolean one){
        if(hs > hf || ws > wf)
            return 0;
        int r = c[wf][hf] + (ws > 0 && hs > 0 ? c[ws - 1][hs - 1] : 0) - (hs > 0 ? c[wf][hs - 1] : 0) - (ws > 0 ? c[ws - 1][hf] : 0);
        return one ? r : (wf - ws + 1) * (hf - hs + 1) - r;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int hcf, wcf, hrf, wrf, hcs, wcs, hrs, wrs, h1, w1, h2, w2, t = sc.nextInt();
        String s1, s2;
        int c[][];
        long r;
        boolean one;
        while(t-- > 0){
            h1 = sc.nextInt();
            w1 = sc.nextInt();
            s1 = sc.next();
            h2 = sc.nextInt();
            w2 = sc.nextInt();
            s2 = sc.next();
            c = new int[w2][h2];
            for(int i = 0; i < w2; i++)
                for(int j = 0; j < h2; j++)
                    c[i][j] = (s2.charAt(j * w2 + i) == '1' ? 1 : 0) + (i > 0 ? c[i - 1][j] : 0) + (j > 0 ? c[i][j - 1] : 0);
            r = 0;
            for(int wi = 0; wi < w1; wi++){
                for(int hi = 0; hi < h1; hi++){
                    one = s1.charAt(hi * w1 + wi) == '1';
                    wcs = wi * w2 / w1;
                    wrs = wi * w2 % w1;
                    wcf = ((wi + 1) * w2 - 1) / w1;
                    wrf = ((wi + 1) * w2 - 1) % w1;
                    hcs = hi * h2 / h1;
                    hrs = hi * h2 % h1;
                    hcf = ((hi + 1) * h2 - 1) / h1;
                    hrf = ((hi + 1) * h2 - 1) % h1;
                    if(wcf > wcs && hcf > hcs)
                        r += w1 * h1 * count(c, hcs + 1, wcs + 1, hcf - 1, wcf - 1, one);
                    if(wcf == wcs){
                        if(hcf == hcs)
                            r += (wrf - wrs + 1) * (hrf - hrs + 1) * count(c, hcs, wcs, hcs, wcs, one);
                        else{
                            r += (wrf - wrs + 1) * (h1 - hrs) * count(c, hcs, wcs, hcs, wcs, one);
                            r += (wrf - wrs + 1) * h1 * count(c, hcs + 1, wcs, hcf - 1, wcs, one);
                            r += (wrf - wrs + 1) * (hrf + 1) * count(c, hcf, wcs, hcf, wcs, one);
                        }
                    }
                    else{
                        if(hcf == hcs){
                            r += (w1 - wrs) * (hrf - hrs + 1) * count(c, hcs, wcs, hcs, wcs, one);
                            r += w1 * (hcf - hcs - 1) * count(c, hcs, wcs + 1, hcs, wcf - 1, one);
                            r += (wrf + 1) * (hrf - hrs + 1) * count(c, hcs, wcf, hcs, wcf, one);
                        }
                        else{
                            r += (w1 - wrs) * (h1 - hrs) * count(c, hcs, wcs, hcs, wcs, one);
                            r += w1 * (h1 - hrs) * count(c, hcs, wcs + 1, hcs, wcf - 1, one);
                            r += (wrf + 1) * (h1 - hrs) * count(c, hcs, wcf, hcs, wcf, one);
                            r += (wrf + 1) * h1 * count(c, hcs + 1, wcf, hcf - 1, wcf, one);
                            r += (wrf + 1) * (hrf + 1) * count(c, hcf, wcf, hcf, wcf, one);
                            r += w1 * (hrf + 1) * count(c, hcf, wcs + 1, hcf, wcf - 1, one);
                            r += (w1 - wrs) * (hrf + 1) * count(c, hcf, wcs, hcf, wcs, one);
                            r += (w1 - wrs) * h1 * count(c, hcs + 1, wcs, hcf - 1, wcs, one);
                        }
                    }
                }
            }
            System.out.println(r);
        }
    }
}
