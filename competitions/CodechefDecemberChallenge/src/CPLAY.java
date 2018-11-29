import java.util.Scanner;

class CPLAY {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String match;
        int m1, m2, i;
        boolean finish;
        while(sc.hasNext()){
            match = sc.next();
            m1 = 0;
            m2 = 0;
            finish = false;
            for(i = 0; !finish && i < 10; i += 2){
                m1 += match.charAt(i) == '1' ? 1 : 0;
                if(m1 > m2 + 5 - i / 2){
                    System.out.println("TEAM-A " + (i + 1));
                    finish = true;
                    break;
                }
                else if(m1 + 4 - i / 2 < m2){
                    System.out.println("TEAM-B " + (i + 1));
                    finish = true;
                    break;
                }
                m2 += match.charAt(i + 1) == '1' ? 1 : 0;
                if(m1 > m2 + 4 - i / 2){
                    System.out.println("TEAM-A " + (i + 2));
                    finish = true;
                    break;
                }
                else if(m1 + 4 - i / 2 < m2){
                    System.out.println("TEAM-B " + (i + 2));
                    finish = true;
                    break;
                }
            }
            for(; !finish && i < match.length(); i += 2){
                m1 += match.charAt(i) == '1' ? 1 : 0;
                m2 += match.charAt(i + 1) == '1' ? 1 : 0;
                if(m1 > m2){
                    System.out.println("TEAM-A " + (i + 2));
                    finish = true;
                    break;
                }
                else if(m1 < m2){
                    System.out.println("TEAM-B " + (i + 2));
                    finish = true;
                    break;
                }
            }
            if(!finish)
                System.out.println("TIE");
        }
    }
}
