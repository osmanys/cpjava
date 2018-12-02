import java.util.*;

public class Solution {

    static final int MAXN = 100001;

    static int spf[] = new int[MAXN];

    static void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++)
            spf[i] = i;

        for (int i = 4; i < MAXN; i += 2)
            spf[i] = 2;

        for (int i = 3; i * i < MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAXN; j += i)
                    if (spf[j] == j)
                        spf[j] = i;
            }
        }
    }

    static ArrayList<Integer> getFactorization(int x) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (x != 1) {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }

    static int binarySearch(int[] arr, int l, int r, int key){
        int index = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(l == r || arr[mid] == key){
                index = mid;
                break;
            } else if(arr[mid] < key)
                l = mid + 1;
            else
                r = mid;
        }
        return index;
    }

    public static void main(String args[]) {
        int nums[] = new int[]{3,5,7,9,10};
        int target = 8;
        int s = binarySearch(nums, 0, nums.length - 1, target);
        System.out.println(nums[s] < target ? s + 1 : s);

        /*int A[] = new int[]{4, 6, 15, 35};

        sieve();
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> primes;
        DisjointUnionSets djs = new DisjointUnionSets(A.length);
        for (int i = 0; i < A.length; i++) {
            primes = getFactorization(A[i]);
            for (int p : primes) {
                if (!hm.containsKey(p))
                    hm.put(p, i);
                else
                    djs.union(i, hm.get(p));
            }
        }
        //Terminar
        */
    }

    static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            if (xRoot == yRoot)
                return;

            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }
}
