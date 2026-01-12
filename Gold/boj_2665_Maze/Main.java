import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, INF = 1_000_000_000;
    static int[][] map, visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], INF);
        }

        bfs();

        System.out.println(visited[n - 1][n - 1]);

    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0, 0));
        visited[0][0] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int add = (map[nx][ny] == 0) ? 1 : 0;
                int nCost = cur.cost + add;

                if(nCost < visited[nx][ny]) {
                    visited[nx][ny] = nCost;
                    pq.offer(new Node(nx, ny, nCost));
                }
            }
        }
    }

}
