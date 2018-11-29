import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class REDBLUE {
    private static CPoint center;

    private static class CPoint{
        private boolean red;
        private long x;
        private long y;

        private CPoint(boolean red, long x, long y){
            this.red = red;
            this.x = x;
            this.y = y;
        }

        private boolean isUp(){
            return y > center.y || (y == center.y && x < center.x);
        }
    }

    private static class SortbyCenter implements Comparator<CPoint> {

        public int compare(CPoint a, CPoint b) {
            long ax, ay, bx, by;
            if(a.isUp()){
                ax = a.x;
                ay = a.y;
            }
            else{
                ax = 2 * center.x - a.x;
                ay = 2 * center.y - a.y;
            }
            if(b.isUp()){
                bx = b.x;
                by = b.y;
            }
            else{
                bx = 2 * center.x - b.x;
                by = 2 * center.y - b.y;
            }

            if (ax >= center.x && bx < center.x)
                return 1;
            if (ax < center.x && bx >= center.x)
                return -1;

            return (ax - center.x) * (by - center.y) - (bx - center.x) * (ay - center.y) < 0 ? -1 : 1;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int _min, _pmin, r, b, n, m, t = sc.nextInt();
        long x, y;
        ArrayList<CPoint> l = new ArrayList<>();
        ArrayList<CPoint> orderl = new ArrayList<>();
        while(t-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            l.clear();
            for(int i = 0; i < n; i++){
                x = sc.nextLong();
                y = sc.nextLong();
                l.add(new CPoint(true, x, y));
            }
            for(int i = 0; i < m; i++){
                x = sc.nextLong();
                y = sc.nextLong();
                l.add(new CPoint(false, x, y));
            }
            _min = m + n;
            for(int i = 0; i < n + m; i++){
                center = l.get(i);
                orderl.clear();
                r = 0;
                b = 0;
                for(int j = 0; j < n + m; j++){
                    if(j != i) {
                        orderl.add(l.get(j));
                        if (l.get(j).isUp()) {
                            if (l.get(j).red)
                                r++;
                            else
                                b++;
                        }
                    }
                }
                if(r + m - b - (center.red ? 0 : 1) < b + n - r - (center.red ? 1 : 0))
                    _pmin = r + m - b - (center.red ? 0 : 1);
                else
                    _pmin = b + n - r - (center.red ? 1 : 0);
                orderl.sort(new SortbyCenter());
                for(int j = 0; j < n + m - 1; j++){
                    if(orderl.get(j).isUp()){
                        if(orderl.get(j).red)
                            r--;
                        else
                            b--;
                    }
                    else{
                        if(orderl.get(j).red)
                            r++;
                        else
                            b++;
                    }
                    if(_pmin > r + m - b - (center.red ? 0 : 1))
                        _pmin = r + m - b - (center.red ? 0 : 1);
                    if(_pmin > b + n - r - (center.red ? 1 : 0))
                        _pmin = b + n - r - (center.red ? 1 : 0);
                }
                if(_min > _pmin)
                    _min = _pmin;
            }
            System.out.println(_min);
        }
    }
}
