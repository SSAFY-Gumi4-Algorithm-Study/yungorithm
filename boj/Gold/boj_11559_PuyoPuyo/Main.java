import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for(int i = 0; i < 12; i++) {
            String s = br.readLine();
            for(int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int chain = 0;
        while(true) {
            visited = new boolean[12][6];
            ArrayList<int[]> toPop = new ArrayList<>();

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    if(map[i][j] == '.' || visited[i][j]) {
                        continue;
                    }

                    ArrayList<int[]> comp = bfs(i, j, map[i][j]);
                    if(comp.size() >= 4) {
                        toPop.addAll(comp);
                    }
                }
            }

            if(toPop.isEmpty()) {
                break;
            }

            for(int[] p : toPop) {
                map[p[0]][p[1]] = '.';
            }

            drop();

            chain++;
        }

        System.out.println(chain);

    }

    public static ArrayList<int[]> bfs(int sx, int sy, char color) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> comp = new ArrayList<>();

        visited[sx][sy] = true;
        q.offer(new int[] { sx, sy });
        comp.add(new int[] { sx, sy });

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
                    continue;
                }

                if(visited[nx][ny] || map[nx][ny] != color) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[] { nx, ny });
                comp.add(new int[] { nx, ny });
            }
        }

        return comp;
    }

    public static void drop() {
        for(int col = 0; col < 6; col++) {
            int down = 11;
            for(int row = 11; row >= 0; row--) {
                if(map[row][col] != '.') {
                    map[down][col] = map[row][col];
                    if(down != row) {
                        map[row][col] = '.';
                    }
                    down--;
                }
            }

            while(down >= 0) {
                map[down][col] = '.';
                down--;
            }
        }
    }

}
