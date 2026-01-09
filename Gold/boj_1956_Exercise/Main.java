import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int v, e, INF = 1_000_000_000;
    static int[][] minDist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        minDist = new int[v + 1][v + 1];
        for(int i = 1; i <= v; i++) {
            Arrays.fill(minDist[i], INF);
        }

        for(int i = 0; i < e; i++) {
            st = new  StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            minDist[from][to] = dist;
        }

        for(int k = 1; k <= v; k++) {
            for(int i = 1; i <= v; i++) {
                if(minDist[i][k] == INF) continue;
                for(int j = 1; j <= v; j++) {
                    if(minDist[k][j] == INF) continue;

                    int nd = minDist[i][k] + minDist[k][j];
                    if(nd < minDist[i][j]) minDist[i][j] = nd;
                }
            }
        }

        int result = INF;
        for(int i = 1; i <= v; i++) {
            result = Math.min(result, minDist[i][i]);
        }

        System.out.println(result == INF ? -1 : result);

    }

}
