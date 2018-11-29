import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
class HMAPPY1 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer[]> groups = new ArrayList<>();
        int gsz, a, idx = 0, cnt = 0, idx2 = -1, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            if (a == 1) {
                if (cnt == 0)
                    idx = i;
                cnt++;
            } else {
                if (cnt > 0) {
                    groups.add(new Integer[]{idx, cnt});
                    cnt = 0;
                }
            }
        }
        gsz = groups.size();
        if (cnt > 0) {
            if (gsz > 0 && groups.get(0)[0] == 0){
                groups.get(0)[0] = idx;
                groups.get(0)[1] += cnt;
            }
            else {
                groups.add(new Integer[]{idx, cnt});
                gsz++;
            }
        }
        idx = -1;
        cnt = 0;
        for (Integer[] g : groups) {
            if (cnt < g[1]) {
                cnt2 = cnt;
                idx2 = idx;
                cnt = g[1] <= k ? g[1] : k;
                idx = g[0];
            } else if (cnt2 < g[1]) {
                cnt2 = g[1] <= k ? g[1] : k;
                idx2 = g[0];
            }
        }
        int max, ci = 0, cg = -1;
        boolean hasg = false;
        if(gsz > 0 && (groups.get(0)[0] == 0 || groups.get(0)[0] + groups.get(0)[1] > n)) {
            hasg = true;
            cg++;
        }
        String qs = sc.next();
        for (int i = 0; i < q; i++) {
            if (qs.charAt(i) == '!') {
                if(hasg && groups.get(cg)[0] == ci)
                    hasg = false;
                if(!hasg && gsz > 0 && (groups.get((gsz + cg - 1) % gsz)[0] + groups.get((gsz + cg - 1) % gsz)[1]) % n == ci){
                    hasg = true;
                    cg = (gsz + cg - 1) % gsz;
                }
                ci = (n + ci - 1) % n;
            } else {
                if(!hasg)
                    System.out.println(cnt);
                else {
                    max = 0;
                    a = groups.get(cg)[1] == n ? n : (n + ci - groups.get(cg)[0]) % n;
                    if(max < a)
                        max = a <= k ? a : k;
                    a = groups.get(cg)[1] == n ? n : (n + groups.get(cg)[0] + groups.get(cg)[1] - ci) % n;
                    if(max < a)
                        max = a <= k ? a : k;
                    if(groups.get(cg)[0] != idx && max < cnt)
                        max = cnt;
                    else if(groups.get(cg)[0] != idx2 && max < cnt2)
                        max = cnt2;
                    System.out.println(max);
                }
            }
        }
    }
}
