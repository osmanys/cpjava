package round1a;

import java.io.*;
import java.util.*;

public class C {

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

    static class Trie {

        final int ALPHABET_SIZE = 26;

        class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];

            boolean isEndOfWord;

            int count;

            TrieNode() {
                isEndOfWord = false;
                count = 0;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }

        TrieNode root = new TrieNode();

        void insert(String key) {
            int level;
            int length = key.length();
            int index;

            TrieNode pCrawl = root;

            for (level = 0; level < length; level++) {
                index = key.charAt(level) - 'A';
                if (pCrawl.children[index] == null)
                    pCrawl.children[index] = new TrieNode();

                pCrawl = pCrawl.children[index];
                pCrawl.count++;
            }

            pCrawl.isEndOfWord = true;
        }

        int countRhyme(){
            return DFSUtil(root);
        }

        int DFSUtil(TrieNode pCrawl)
        {
            if(pCrawl == null)
                return 0;
            int cnt = 0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
            {
                if(pCrawl.children[i] != null){
                    cnt += DFSUtil(pCrawl.children[i]);
                }
            }

            if(pCrawl.count - 2 * cnt > 1)
                cnt++;

            return cnt;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n, tc = sc.nextInt();
        String d;
        Trie trie;
        StringBuilder sb;
        for (int t = 1; t <= tc; t++) {
            trie = new Trie();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                d = sc.next();
                sb = new StringBuilder();
                for(int j = d.length() - 1; j >= 0; j--)
                {
                    sb.append(d.charAt(j));
                }
                trie.insert(sb.toString());
            }

            System.out.println("Case #" + t + ": " + ( 2 * trie.countRhyme() ));
        }
    }
}
