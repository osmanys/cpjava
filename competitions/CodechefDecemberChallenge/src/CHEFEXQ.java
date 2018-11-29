import java.util.Scanner;

class CHEFEXQ {
    private static final int MAX = 1050000;
    private static final int MAXN = 105000;
    private static final int MAXBUCKETS = 350;

    private static int buckets;
    private static int[][] v = new int[MAXBUCKETS][MAX];
    private static int[] tblock = new int[MAXBUCKETS];
    private static int[] d = new int[MAXN];
    private static int[] acd = new int[MAXN];

    private static void build(int n){
        buckets = (int)Math.sqrt(n);
        int i, x = 0;
        for(i = 0; i < n; i++){
            if(i > 0 && i % buckets == 0) {
                tblock[i / buckets - 1] = x;
                x = 0;
            }
            x = x ^ d[i];
            acd[i] = x;
            v[i / buckets][x]++;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int t, i, k, b, r, ac;
        for(int j = 0; j < n; j++)
            d[j] = sc.nextInt();
        build(n);
        for(int j = 0; j < q; j++){
            t = sc.nextInt();
            i = sc.nextInt();
            k = sc.nextInt();
            if(t == 1){
                i--;
                b = i / buckets;
                for(int l = i; l < (b + 1) * buckets; l++){
                    v[b][acd[l]]--;
                    acd[l] = acd[l] ^ d[i] ^ k;
                    v[b][acd[l]]++;
                }
                tblock[b] = tblock[b] ^ d[i] ^ k;
                d[i] = k;
            }
            else{
                r = 0;
                b = (i - 1) / buckets;
                ac = 0;
                for(int l = 0; l < b; l++){
                    r += v[l][k ^ ac];
                    ac = ac ^ tblock[l];
                }
                for(int l = b * buckets; l < i; l++)
                    if(acd[l] == (ac ^ k))
                        r++;
                System.out.println(r);
            }
        }
    }
}
