import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

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

    static int findPawn(char board[][], int wKr, int wKc){
        int c = 0;
        for(; c < 8; c++){
            if(board[1][c] == 'P' && board[0][c] == '#'){
                board[1][c] = '#';
                board[0][c] = 'P';
                if(!isWhiteInCheck(board, wKr, wKc)){
                    board[0][c] = '#';
                    board[1][c] = 'P';
                    break;
                }
                board[0][c] = '#';
                board[1][c] = 'P';
            }
        }
        return c;
    }

    static boolean isWhiteInCheck(char board[][], int Kr, int Kc){
        int d[][] = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int c[][] = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int kn[][] = new int[][]{{2, -1}, {2, 1}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}};
        for(int i = 0; i < 4; i++) {
            for (int j = 1; Kr + j * d[i][0] >= 0 && Kr + j * d[i][0] < 8 && Kc + j * d[i][1] >= 0 && Kc + j * d[i][1] < 8; j++) {
                if (board[Kr + j * d[i][0]][Kc + j * d[i][1]] == 'b' || board[Kr + j * d[i][0]][Kc + j * d[i][1]] == 'q')
                    return true;
                else if (board[Kr + j * d[i][0]][Kc + j * d[i][1]] != '#')
                    break;
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 1; Kr + j * c[i][0] >= 0 && Kr + j * c[i][0] < 8 && Kc + j * c[i][1] >= 0 && Kc + j * c[i][1] < 8; j++) {
                if (board[Kr + j * c[i][0]][Kc + j * c[i][1]] == 'r' || board[Kr + j * c[i][0]][Kc + j * c[i][1]] == 'q')
                    return true;
                else if (board[Kr + j * c[i][0]][Kc + j * c[i][1]] != '#')
                    break;
            }
        }
        for(int i = 0; i < 8; i++) {
            if(Kr + kn[i][0] >= 0 && Kr + kn[i][0] < 8 && Kc + kn[i][1] >= 0 && Kc + kn[i][1] < 8 && board[Kr + kn[i][0]][Kc + kn[i][1]] == 'n')
                return true;
        }
        return false;
    }

    static int countCheck(char board[][], int c, int bKr, int bKc){
        int r = 0;
        board[1][c] = '#';
        char p[] = new char[] {'Q', 'R', 'B', 'N'};
        for(int i = 0; i < 4; i++) {
            board[0][c] = p[i];
            if (isBlackInCheck(board, bKr, bKc))
                r++;
        }
        board[0][c] = '#';
        board[1][c] = 'P';
        return r;
    }

    static boolean isBlackInCheck(char board[][], int Kr, int Kc){
        int d[][] = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int c[][] = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int kn[][] = new int[][]{{2, -1}, {2, 1}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}};
        for(int i = 0; i < 4; i++) {
            for (int j = 1; Kr + j * d[i][0] >= 0 && Kr + j * d[i][0] < 8 && Kc + j * d[i][1] >= 0 && Kc + j * d[i][1] < 8; j++) {
                if (board[Kr + j * d[i][0]][Kc + j * d[i][1]] == 'B' || board[Kr + j * d[i][0]][Kc + j * d[i][1]] == 'Q')
                    return true;
                else if (board[Kr + j * d[i][0]][Kc + j * d[i][1]] != '#')
                    break;
            }
        }
        for(int i = 0; i < 4; i++) {
            for (int j = 1; Kr + j * c[i][0] >= 0 && Kr + j * c[i][0] < 8 && Kc + j * c[i][1] >= 0 && Kc + j * c[i][1] < 8; j++) {
                if (board[Kr + j * c[i][0]][Kc + j * c[i][1]] == 'R' || board[Kr + j * c[i][0]][Kc + j * c[i][1]] == 'Q')
                    return true;
                else if (board[Kr + j * c[i][0]][Kc + j * c[i][1]] != '#')
                    break;
            }
        }
        for(int i = 0; i < 8; i++) {
            if(Kr + kn[i][0] >= 0 && Kr + kn[i][0] < 8 && Kc + kn[i][1] >= 0 && Kc + kn[i][1] < 8 && board[Kr + kn[i][0]][Kc + kn[i][1]] == 'N')
                return true;
        }
        return false;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int c, wKr = 0, wKc = 0, bKr = 0, bKc = 0, t = sc.nextInt();
        String l;
        char board[][] = new char[8][8];
        while(t-- > 0){
            for(int i = 0; i < 8; i++){
                l = sc.nextLine();
                for(int j = 0; j < 8; j++){
                    board[i][j] = l.charAt(j);
                    if(board[i][j] == 'K'){
                        wKr = i;
                        wKc = j;
                    }
                    else if(board[i][j] == 'k'){
                        bKr = i;
                        bKc = j;
                    }
                }
            }
            c = findPawn(board, wKr, wKc);
            System.out.println(countCheck(board, c, bKr, bKc));
        }
    }
}
