import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int r, c, t;
    static int[][] map, tmp;
    static int top = -1, bottom = -1;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    if(top == -1) top = i;
                    else bottom = i;
                }
            }
        }

        for(int i = 0; i < t; i++) {
            spread();
            operate();
        }

        int result = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] > 0) result += map[i][j];
            }
        }

        System.out.println(result);

    }

    public static void spread() {
        tmp = new int[r][c];
        tmp[top][0] = -1;
        tmp[bottom][0] = -1;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] <= 0) continue;

                int give = map[i][j] / 5;
                int cnt = 0;

                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                    if(map[nr][nc] == -1) continue;

                    tmp[nr][nc] += give;
                    cnt++;
                }

                tmp[i][j] += map[i][j] - give * cnt;
            }
        }

        map = tmp;
    }

    public static void operate() {
        for(int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for(int j = 0; j < c - 1; j++) map[0][j] = map[0][j + 1];
        for(int i = 0; i < top; i++) map[i][c - 1] = map[i + 1][c - 1];
        for(int j = c - 1; j > 1; j--) map[top][j] = map[top][j - 1];
        map[top][1] = 0;

        for (int i = bottom + 1; i < r - 1; i++) map[i][0] = map[i + 1][0];
        for (int j = 0; j < c - 1; j++) map[r - 1][j] = map[r - 1][j + 1];
        for (int i = r - 1; i > bottom; i--) map[i][c - 1] = map[i - 1][c - 1];
        for (int j = c - 1; j > 1; j--) map[bottom][j] = map[bottom][j - 1];
        map[bottom][1] = 0;

        map[top][0] = -1;
        map[bottom][0] = -1;
    }

}
