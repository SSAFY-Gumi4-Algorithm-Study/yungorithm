import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] visited;
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
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {
                    int max = bfs(i, j);
                    if(result < max) result = max;
                }
            }
        }

        System.out.println(result);

    }

    public static int bfs(int s, int e) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        init();

        q.offer(new int[] { s, e });
        visited[s][e] = 0;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(map[nx][ny] == 'W') continue;

                if(visited[nx][ny] != -1) continue;

                visited[nx][ny] = visited[curX][curY] + 1;
                q.offer(new int[] { nx, ny });
            }
        }

        return max();
    }

    public static void init() {
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
    }

    public static int max() {
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] > max) max = visited[i][j];
            }
        }
        return max;
    }

}
