import java.util.Scanner;

class CHEFUNI {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int tmp, x, y, z, a, b, c, t = sc.nextInt();
        long r;
        while(t-- > 0){
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if(x > y){
                tmp = x;
                x = y;
                y = tmp;
            }
            if(x > z){
                tmp = x;
                x = z;
                z = tmp;
            }
            if(y > z){
                tmp = y;
                y = z;
                z = tmp;
            }
            r = 1L * (x + y + z) * a;
            if(r > 1L * x * c + 1L * (y + z - 2 * x) * a)
                r = 1L * x * c + 1L * (y + z - 2 * x) * a;
            if(r > 1L * x * c + 1L * (y - x) * b + 1L * (z - y) * a)
                r = 1L * x * c + 1L * (y - x) * b + 1L * (z - y) * a;
            if(z <= x + y){
                if(r > 1L * (x + y - z) * c + 1L * (2 * z - x - y) * b)
                    r = 1L * (x + y - z) * c + 1L * (2 * z - x - y) * b;
                if((x + y + z) % 2 == 0) {
                    if (r > 1L * (x + y + z) * b / 2)
                        r = 1L * (x + y + z) * b / 2;
                }
                else if(a < c - b) {
                    if (r > 1L * (x + y + z - 1) * b / 2 + a)
                        r = 1L * (x + y + z - 1) * b / 2 + a;
                }
                else if(r > 1L * (x + y + z - 3) * b / 2 + c)
                    r = 1L * (x + y + z - 3) * b / 2 + c;
            }
            else if(r > 1L * (x + y) * b + 1L * (z - x - y) * a)
                r = 1L * (x + y) * b + 1L * (z - x - y) * a;
            System.out.println(r);
        }
    }
}
