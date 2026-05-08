import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] dist;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        System.out.println(result);

    }

    private static int bfs(int sx, int sy) {
        dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { sx, sy });
        dist[sx][sy] = 0;

        int max = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            max = Math.max(max, dist[curX][curY]);

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if(map[nx][ny] == 'W') {
                    continue;
                }

                if(dist[nx][ny] != -1) {
                    continue;
                }

                dist[nx][ny] = dist[curX][curY] + 1;
                q.offer(new int[] { nx, ny });
            }
        }

        return max;
    }

}
