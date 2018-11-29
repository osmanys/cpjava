public class comparators{

    /**
     * Comparator to geometry
     */
    public static Comparator<int[]> comp1 = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            long ax = a[0], ay = a[1];
            long bx = b[0], by = b[1];
            int za = ay > 0 || ay == 0 && ax > 0 ? 0 : 1;
            int zb = by > 0 || by == 0 && bx > 0 ? 0 : 1;
            if (za != zb) return za - zb;
            if (ay * bx - ax * by != 0) return Long.signum(ay * bx - ax * by);
            return Long.signum((ax * ax + ay * ay) - (bx * bx + by * by));
        }
    };
}