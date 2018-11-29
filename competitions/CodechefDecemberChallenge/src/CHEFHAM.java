import java.util.Scanner;

class CHEFHAM {
    private static final int MAX = 100001;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int f, temp, i, n, t = sc.nextInt();
        int[] d, pos;
        while(t-- > 0){
            n = sc.nextInt();
            d = new int[n];
            pos = new int[MAX];
            for(i = 0; i < n; i++)
                d[i] = sc.nextInt();
            i = 0;
            f = 0;
            while(i < n){
                if(i == n - 1){
                    f = 1;
                    if(i > 1 && d[0] != d[i] && pos[d[i]] != 1){
                        temp = d[i];
                        d[i] = d[0];
                        d[0] = temp;
                        f--;
                    }
                    else if(i > 2 && d[1] != d[i] && pos[d[i]] != 2){
                        temp = d[i];
                        d[i] = d[1];
                        d[1] = temp;
                        f--;
                    }
                    else if(i > 3){
                        temp = d[i];
                        d[i] = d[2];
                        d[2] = temp;
                        f--;
                    }
                    i = n;
                }
                else if(d[i] != d[i + 1]){
                    pos[d[i]] = i + 1;
                    pos[d[i + 1]] = i + 2;
                    temp = d[i];
                    d[i] = d[i + 1];
                    d[i + 1] = temp;
                    i += 2;
                }
                else if(i < n - 3){
                    pos[d[i]] = i + 1;
                    pos[d[i + 1]] = i + 2;
                    pos[d[i + 2]] = i + 3;
                    pos[d[i + 3]] = i + 4;
                    temp = d[i];
                    d[i] = d[i + 2];
                    d[i + 2] = temp;
                    temp = d[i + 1];
                    d[i + 1] = d[i + 3];
                    d[i + 3] = temp;
                    i += 4;
                }
                else if(i == n - 3){
                    pos[d[i]] = i + 1;
                    pos[d[i + 1]] = i + 2;
                    pos[d[i + 2]] = i + 3;
                    temp = d[i];
                    d[i] = d[i + 2];
                    d[i + 2] = temp;
                    if(n > 3){
                        temp = d[i + 1];
                        d[i + 1] = d[i - 1];
                        d[i - 1] = temp;
                    }
                    else
                        f = 1;
                    i = n;
                }
                else if(i == n - 2){
                    pos[d[i]] = i + 1;
                    pos[d[i + 1]] = i + 2;
                    f = 2;
                    if(n > 2){
                        temp = d[i];
                        d[i] = d[i - 1];
                        d[i - 1] = temp;
                        f--;
                    }
                    if(n > 3){
                        temp = d[i + 1];
                        d[i + 1] = d[i - 2];
                        d[i - 2] = temp;
                        f--;
                    }
                    i = n;
                }
            }
            System.out.println(n - f);
            for(i = 0; i < n; i++)
                System.out.print(d[i] + " ");
            System.out.println();
        }
    }
}
