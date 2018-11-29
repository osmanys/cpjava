import java.io.*;
import java.util.*;

public class POINPOLY {

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

    static class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static long areaTriangle(Point a, Point b, Point c) {
        return (1L * a.x * (b.y - c.y) + 1L * b.x * (c.y - a.y) + 1L * c.x * (a.y - b.y));
    }

    static boolean inConvexPoly(Point poly[], Point p) {
        int start = 1, last = poly.length - 1;
        while(last - start > 1) {
            int mid = (start + last) / 2;
            if(areaTriangle(poly[0], poly[mid], p) < 0)
                last = mid;
            else
                start = mid;
        }

        long r0 = Math.abs(areaTriangle(poly[0], poly[start], poly[last]));

        long r1 = Math.abs(areaTriangle(poly[0], poly[start], p));
        long r2 = Math.abs(areaTriangle(poly[0], poly[last], p));
        long r3 = Math.abs(areaTriangle(poly[start], poly[last], p));

        long r4 = areaTriangle(poly[0], poly[1], p);
        long r5 = areaTriangle(poly[0], poly[poly.length - 1], p);

        return (r0 == (r1 + r2 + r3) && r3 != 0 && r4 != 0 && r5 != 0);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int tmp, limit, c, pTop, pBottom, pLeft, pRigth, x, y, n, t = sc.nextInt();
        Point rpoly[], poly[], p;
        boolean flip;
        ArrayList<Point> r;
        while(t-- > 0){
            n = sc.nextInt();
            poly = new Point[n];
            pLeft = -1;
            pRigth = -1;
            pTop = -1;
            pBottom = -1;
            for(int i = 0; i < n; i++){
                x = sc.nextInt();
                y = sc.nextInt();
                poly[i] = new Point(x, y);
                if(pLeft == -1 || x < poly[pLeft].x)
                    pLeft = i;
                if(pRigth == -1 || x > poly[pRigth].x)
                    pRigth = i;
                if(pTop == -1 || y > poly[pTop].y)
                    pTop = i;
                if(pBottom == -1 || y < poly[pBottom].y)
                    pBottom = i;
            }
            if(poly[pRigth].x - poly[pLeft].x > poly[pTop].y - poly[pBottom].y)
                flip = true;
            else
                flip = false;
            if(flip){
                rpoly = new Point[n];
                for(int i = 0; i < n; i++)
                    rpoly[i] = new Point(poly[n - 1 - i].y, poly[n - 1 - i].x);
                poly = rpoly;
                tmp = n - 1 - pRigth;
                pRigth = n - 1 - pTop;
                pTop = tmp;
                tmp = n - 1 - pLeft;
                pLeft = n - 1 - pBottom;
                pBottom = tmp;
            }
            r = new ArrayList<>();
            limit = n / 10;
            for(int i = 0; i < n && r.size() < limit; i++){
                if((n + i - pLeft) % n < (n + pRigth - pLeft) % n){
                    for(x = poly[i].x; x < poly[(i + 1) % n].x && r.size() < limit; x++) {
                        y = (int)Math.floor(1L * (poly[(i + 1) % n].y - poly[i].y) * (x - poly[i].x) / (1D * poly[(i + 1) % n].x - poly[i].x) + poly[i].y);
                        c = 1;
                        while (r.size() < limit) {
                            p = new Point(x, y + c);
                            if (!inConvexPoly(poly, p))
                                break;
                            r.add(p);
                            c++;
                        }
                    }
                }
            }
            if(r.size() < limit)
                System.out.println(-1);
            else {
                for(int i = 0; i < limit; i++)
                    System.out.println(flip ? r.get(i).y + " " + r.get(i).x : r.get(i).x + " " + r.get(i).y);
            }
        }
    }
}