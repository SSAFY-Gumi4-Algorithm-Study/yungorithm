import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] matched;
    static int matchCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선은 n-1개
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        matched = new boolean[n + 1];

        dfs(1, 0);

        System.out.println(matchCnt);
    }

    public static void dfs(int u, int point) {
        for (int v : list[u]) {
            if (v == point) {
            	continue;
            }
            dfs(v, u);
        }

        for (int v : list[u]) {
            if (v == point) {
            	continue;
            }
            if (!matched[u] && !matched[v]) {
                matched[u] = matched[v] = true;
                matchCnt++;
            }
        }
    }
}
