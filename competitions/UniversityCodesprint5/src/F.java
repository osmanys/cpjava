import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class F {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        KthPath solver = new KthPath();
        solver.solve(1, in, out);
        out.close();
    }
    static class KthPath {
        public long INF = 1L << 60;
        List<KthPath.Edge>[] graph;
        HashMap<Integer, HashSet<Integer>> ver;
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt(), m = in.nextInt();
            String name = in.next();
            graph = LUtils.genArrayList(n);
            ver = new HashMap<>();
            for(int i = 0; i < n; i++)
                ver.put(i, new HashSet<>());
            for (int i = 0; i < m; i++) {
                int a = in.nextInt() - 1, b = in.nextInt() - 1, c = name.charAt(b) - 'a';
                if(!ver.get(a).contains(b)) {
                    graph[a].add(new KthPath.Edge(b, c));
                    ver.get(a).add(b);
                }
            }
            int st = in.nextInt() - 1;
            int fn = in.nextInt() - 1;
            int[] q = new int[n];
            int f = 0, b = 0;
            q[b++] = st;
            int[] depth = new int[n];
            Arrays.fill(depth, 1 << 29);
            depth[st] = 1;
            boolean[] vis = new boolean[n];
            vis[st] = true;
            while (f < b) {
                int c = q[f++];
                for (KthPath.Edge e : graph[c]) {
                    if (!vis[e.to]) {
                        vis[e.to] = true;
                        depth[e.to] = depth[c] + 1;
                        q[b++] = e.to;
                    }
                }
            }
            long[] count = new long[n];
            count[fn] = 1;
            for (int i = b - 1; i >= 0; i--) {
                int c = q[i];
                for (KthPath.Edge e : graph[c]) {
                    //if (depth[e.to] == depth[c] + 1) {
                        count[c] += count[e.to];
                        if (count[c] >= INF) count[c] = INF;
                    //}
                }
            }
            if (count[st] == 0) {
                out.println("No way");
                return;
            }
            HashMap<Integer, Long> active = new HashMap<>();
            active.put(st, 1L);
            char[] c = new char[n];
            int id = 0;
            while (!active.containsKey(fn)) {
                for (int ll = 0; ll < 26; ll++) {
                    final int let = ll;
                    long[] tot = {0};
                    active.forEach((x, y) -> {
                        for (KthPath.Edge e : graph[x]) {
                            if (e.c == let && depth[e.to] == depth[x] + 1) {
                                BigInteger bb = BigInteger.valueOf(count[e.to]).multiply(BigInteger.valueOf(y));
                                if (bb.compareTo(BigInteger.valueOf(INF)) > 0) bb = BigInteger.valueOf(INF);
                                tot[0] += bb.longValue();
                                if (tot[0] >= INF) tot[0] = INF;
                            }
                        }
                    });
                    if (tot[0] > 0) {
                        c[id++] = (char) ('a' + let);
                        HashMap<Integer, Long> nactive = new HashMap<>();
                        active.forEach((x, y) -> {
                            for (KthPath.Edge e : graph[x]) {
                                if (e.c == let && depth[e.to] == depth[x] + 1) {
                                    nactive.merge(e.to, y, (r, s) -> Math.min(INF, r + s));
                                }
                            }
                        });
                        active = nactive;
                        break;
                    }
                }
            }
            out.println(name.charAt(st) + new String(c, 0, id));
        }
        static class Edge {
            public int to;
            public int c;
            public Edge(int to, int c) {
                this.to = to;
                this.c = c;
            }
        }
    }
    static class LUtils {
        public static <E> List<E>[] genArrayList(int size) {
            return Stream.generate(ArrayList::new).limit(size).toArray(List[]::new);
        }
    }
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;
                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }
                    if (this.numChars <= 0) {
                        return -1;
                    }
                }
                return this.buf[this.curChar++];
            }
        }
        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }
            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }
            int res = 0;
            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }
            throw new InputMismatchException();
        }
        public long nextLong() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }
            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }
            long res = 0L;
            while (c >= 48 && c <= 57) {
                res *= 10L;
                res += (long) (c - 48);
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * (long) sgn;
                }
            }
            throw new InputMismatchException();
        }
        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }
            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);
            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }
            return result.toString();
        }
        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }
    }
    static class OutputWriter {
        private final PrintWriter writer;
        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }
        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }
        public void println(Object... objects) {
            print(objects);
            writer.println();
        }
        public void close() {
            writer.close();
        }
        public void println(int i) {
            writer.println(i);
        }
    }
}
