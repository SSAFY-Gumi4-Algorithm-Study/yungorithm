import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];
    static ArrayList<int[]> blanks;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        blanks = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        boolean flag = dfs(0);
        if(flag) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }
    }

    static boolean dfs(int idx) {
        if(idx == blanks.size()) {
            return true;
        }

        int[] cur = blanks.get(idx);
        int r = cur[0];
        int c = cur[1];

        for(int num = 1; num <= 9; num++) {
            if(canPlace(r, c, num)) {
                board[r][c] = num;

                if(dfs(idx + 1)) {
                    return true;
                }

                board[r][c] = 0;
            }
        }

        return false;
    }

    static boolean canPlace(int r, int c, int num) {
        for(int j = 0; j < 9; j++) {
            if (board[r][j] == num) return false;
        }

        for(int i = 0; i < 9; i++) {
            if(board[i][c] == num) return false;
        }

        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;

        for(int i = startR; i < startR + 3; i++) {
            for(int j = startC; j < startC + 3; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }

}
